package nle.spring.webflux.example.stocktrading.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import nle.spring.webflux.example.stocktrading.dto.StockRequest;
import nle.spring.webflux.example.stocktrading.dto.StockResponse;
import nle.spring.webflux.example.stocktrading.exception.StockCreationException;
import nle.spring.webflux.example.stocktrading.exception.StockNotFoundException;
import nle.spring.webflux.example.stocktrading.repository.StocksRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;
import lombok.AllArgsConstructor;

@Slf4j
@Service
@AllArgsConstructor
public class StocksService {
	@Autowired
	private StocksRepository stocksRepository;
	
	public Mono<StockResponse> getOneStock(String id) {
		//use method reference StockResponse::fromModel instead of lambda expression stock -> StockResponse.fromModel(stock)
		return stocksRepository.findById(id)//1. get stock by id
				.map(StockResponse::fromModel)//2. if found stock -> map to StockResponse
				.switchIfEmpty(Mono.error(//3. if empty stock map -> create and throw StockNotFoundException
						new StockNotFoundException("Stock not found with id: " + id)))
				.doFirst(() -> log.info("Retriving Stock with id : {}",id)) //Peek operator
				.doOnNext(stock -> log.info("Stock found {}", stock))    //peek operator
				.doOnError(ex -> log.error("Something when wrong while retriving stock with id {}", id, ex)) //peek operator
				.doOnTerminate(() -> log.info("Finalize retriving stock")) //peek operator
				.doFinally(signalType -> log.info("Finalize retriving Stock with signal type {}", signalType)); //peek operator
	}
	
	public Flux<StockResponse> getAllStocks() {
		return stocksRepository.findAll()
				.map(StockResponse::fromModel)
				.doFirst(() -> log.info("Retriving all Stocks"))
				.doOnNext(stock -> log.info("Stock found {}", stock))
				.doOnError(ex -> log.error("Exception while retriving stock {}", ex))
				.doOnTerminate(() -> log.info("Finalize retriving stocks"))
				.doFinally(signalType -> log.info("Finalize retriving stocks with signal type {}", signalType));
	}
	
	public Mono<StockResponse> createStock(StockRequest stockRequest) {
		return Mono.just(stockRequest) //encapsulate stockRequest in reactive pineline
				.map(StockRequest::toModel) //convert stock request to model to prepare to save data | already in reactive context -> allow on Error excecuted when exception throwed
				.flatMap(stock -> stocksRepository.save(stock)) //call repository to save stock
				.map(StockResponse::fromModel) //map model to stock response
				//.onErrorReturn(StockResponse.builder().build()); //catch exception and return empty response
//				.onErrorResume(ex -> {                                  //catch exception 
//					log.warn("Exception throw during create stock", ex); //print log
//					return Mono.just(StockResponse.builder().build()); //return empty response
//				});	
				.onErrorMap(ex -> new StockCreationException(ex.getMessage()));//create custom exceptio -> will be handle by StockExceptionHandler
				
	}

	public Flux<StockResponse> getStocksWithParam(BigDecimal priceGreaterThan) {
		return stocksRepository.findAll()
				.filter(stock -> stock.getPrice().compareTo(priceGreaterThan) > 0)
				.map(StockResponse::fromModel);
				
	}
}

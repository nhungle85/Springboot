package nle.spring.webflux.example.stocktrading.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import nle.spring.webflux.example.stocktrading.dto.StockRequest;
import nle.spring.webflux.example.stocktrading.dto.StockResponse;
import nle.spring.webflux.example.stocktrading.repository.StocksRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class StocksService {
	@Autowired
	private StocksRepository stocksRepository;
	
	public Mono<StockResponse> getOneStock(String id) {
		//use method reference StockResponse::fromModel instead of lambda expression stock -> StockResponse.fromModel(stock)
		return stocksRepository.findById(id).map(StockResponse::fromModel);
	}
	
	public Flux<StockResponse> getAllStocks() {
		return stocksRepository.findAll()
				.map(StockResponse::fromModel);
	}
	
	public Mono<StockResponse> createStock(StockRequest stockRequest) {
		return stocksRepository.save(stockRequest.toModel())
				.map(StockResponse::fromModel);
	}
}

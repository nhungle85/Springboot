package nle.spring.webflux.example.stocktrading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nle.spring.webflux.example.stocktrading.dto.StockRequest;
import nle.spring.webflux.example.stocktrading.dto.StockResponse;
import nle.spring.webflux.example.stocktrading.service.StocksService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/stocks")
public class StocksController {
	
	@Autowired
	private StocksService stocksService;

	@GetMapping("/{id}")
	public Mono<StockResponse> getOneStock(@PathVariable String id) {
		return stocksService.getOneStock(id);
	}
	
	@GetMapping
	public Flux<StockResponse> getAllStocks() {
		return stocksService.getAllStocks();
	}

	@PostMapping
	public Mono<StockResponse> createStock(@RequestBody StockRequest stock) {
		return stocksService.createStock(stock);
	}
	
}

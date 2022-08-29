package nle.spring.webflux.example.stocktrading.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import nle.spring.webflux.example.stocktrading.model.Stock;

@Repository
public interface StocksRepository extends ReactiveMongoRepository<Stock, String>{

}

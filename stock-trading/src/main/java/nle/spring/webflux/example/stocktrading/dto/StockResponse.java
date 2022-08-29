package nle.spring.webflux.example.stocktrading.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import nle.spring.webflux.example.stocktrading.model.Stock;

@Data
@Builder
@AllArgsConstructor

public class StockResponse {
	private String id;
	
	@JsonProperty("stockName")
	private String name;
	
	private BigDecimal price;
	
	private String currency;
	
	public static StockResponse fromModel(Stock stock) {
		return StockResponse.builder()
				.id(stock.getId())
				.name(stock.getName())
				.price(stock.getPrice())
				.currency(stock.getCurrency())
				.build();
	}
	
}

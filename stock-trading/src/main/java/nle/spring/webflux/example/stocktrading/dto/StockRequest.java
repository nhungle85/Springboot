package nle.spring.webflux.example.stocktrading.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nle.spring.webflux.example.stocktrading.model.Stock;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class StockRequest {
	@JsonProperty("stockName")
	private String name;
	
	private BigDecimal price;
	
	private String currency;

	public Stock toModel() {
		return Stock.builder()
				.name(this.name)
				.currency(this.currency)
				.price(this.price).build();
	}
}

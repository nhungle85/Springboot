package nle.spring.webflux.example.stocktrading.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Stock {
	@Id
	private String id;
	
	private String name;
	
	@NonNull
	private BigDecimal price;	
	
	private String currency;

}

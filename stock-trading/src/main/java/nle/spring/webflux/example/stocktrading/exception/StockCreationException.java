package nle.spring.webflux.example.stocktrading.exception;

public class StockCreationException extends RuntimeException {
	public StockCreationException(String message) {
		super(message);
	}
	
}

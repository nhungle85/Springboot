package nle.spring.webflux.example.stocktrading.exception;

public class StockNotFoundException extends RuntimeException {
	
	public StockNotFoundException(String message) {
        super(message);
    }
}

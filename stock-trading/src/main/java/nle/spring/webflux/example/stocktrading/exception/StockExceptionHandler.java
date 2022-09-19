package nle.spring.webflux.example.stocktrading.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StockExceptionHandler {

	@ExceptionHandler(StockNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessage handleStockNotFoundException(StockNotFoundException ex) {
		return ErrorMessage.builder()
				.message(ex.getMessage())
				.build();
	}
	
	@ExceptionHandler(StockCreationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessage handleStockCreateException(StockCreationException ex) {
		return ErrorMessage.builder()
				.message(ex.getMessage())
				.build();
	}
}

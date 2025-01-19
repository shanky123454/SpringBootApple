package in.com.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.com.stockprice.Exception.StockNotFoundException;

@RestControllerAdvice
public class Exceptionhandler {

	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<String> stockNotFoundException(StockNotFoundException exception){
		System.out.println("stock not found with the given id");
		String msg = exception.getMessage();
		System.out.println(msg);
		return new  ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> otherException(Exception exception){
		String msg = exception.getMessage();
		return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

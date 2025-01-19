package in.com.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.com.error.Error;
import in.com.exception.CricketerNotFoundException;

@RestControllerAdvice
public class GlobalExceptionhandler {

	@ExceptionHandler(CricketerNotFoundException.class)
	public ResponseEntity<Error> handleRecordNotFoundException(CricketerNotFoundException se){
		return new ResponseEntity<>( new Error(LocalDateTime.now(),se.getMessage(),"Record not found"), HttpStatus.OK);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleOtherException(Exception exception){
		return new ResponseEntity<>(new Error(LocalDateTime.now(),exception.getMessage(),"Internal server error"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

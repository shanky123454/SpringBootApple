package in.com.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.com.error.ErrorDetails;
import in.com.exception.UserNotFoundException;



@RestControllerAdvice
public class TouristErrorControllerAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFound(UserNotFoundException tf) {
		System.out.println("TouristErrorControllerAdvice.handleTouristNotFound()");

		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), tf.getMessage(), "404-NotFound");

		return new ResponseEntity<ErrorDetails>(details, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleAllProblems(Exception e) {
		System.out.println("TouristErrorControllerAdvice.handleAllProblems()");
		ErrorDetails details = new ErrorDetails(LocalDateTime.now(), e.getMessage(), "Problem in exeuction");
		return new ResponseEntity<ErrorDetails>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
}

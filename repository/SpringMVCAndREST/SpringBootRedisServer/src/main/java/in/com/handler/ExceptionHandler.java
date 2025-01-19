package in.com.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.com.exception.StudentNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> studentNotFoundException(StudentNotFoundException exception ){
		System.out.println("Student not found with the given id");
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleOtherException(Exception exception){
		System.out.println("ExceptionHandler.handleOtherException()");
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
		
	}
	
}

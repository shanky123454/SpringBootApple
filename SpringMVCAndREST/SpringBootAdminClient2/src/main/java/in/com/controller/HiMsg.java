package in.com.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client2")
public class HiMsg {

	@GetMapping(value = "/hi/{name}")
	public ResponseEntity<String> hiMsg( @PathVariable String name) {
		
		LocalDateTime dateTime = LocalDateTime.now();
		
		String msg = name +" "+ dateTime;
		
		return new ResponseEntity<>(msg, HttpStatus.OK);
		
	}
}

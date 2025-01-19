package in.com.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping(value = "/first")
public class controller {
	
	@GetMapping(value = "/result")
	//@ResponseBody
	public ResponseEntity<String> getResult()
	{
		LocalDateTime dateTime = LocalDateTime.now();
		int hour = dateTime.getHour();
		String body = null;
		if (hour < 12)
		body = "Good Morning";
		else if (hour < 16)
		body = "Good Afternoon";
		else if (hour < 20)
		body = "Good Evening";
		else
		body = "Good night";
		
		ResponseEntity<String> entity = new ResponseEntity<String>(body, HttpStatus.OK);

		return entity;
	}

}

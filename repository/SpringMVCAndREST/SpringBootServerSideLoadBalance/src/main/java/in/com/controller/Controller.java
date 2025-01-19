package in.com.controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Controller {
	
	@GetMapping(value = "/result")
	public String getResult() {
		
		return "HI SHASHANK" + LocalDateTime.now();
	}

}

package in.com.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping(value = "/first")
public class Controller {
	
	@GetMapping(value = "/result")
	@HystrixCommand(fallbackMethod = "getAlternateResponse")
	public String getResponse(){
		System.out.println("Controller.getResponse()");
		
		if(new Random().nextInt(10)<= 10) {
			throw new RuntimeException("Dummy");
		}
		return "Hello from response";
	}
	
	public String getAlternateResponse() {
		System.out.println("Controller.getAlternateResponse()");
		
		return "Hello from getAlternateResponse";
	}

}

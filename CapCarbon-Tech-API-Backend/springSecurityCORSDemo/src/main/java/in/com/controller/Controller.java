package in.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/demo")
public class Controller {

	@GetMapping("/home")
	public ResponseEntity<String> getHomePage(){
		String URL = "http://localhost:9999/demo/home";
		

		 WebClient webClient = WebClient.create();
		 
		 System.out.println("***Synchronous: Restcall started  for get ******");
		 
	String response = webClient.get().uri(URL).accept(MediaType.APPLICATION_JSON).
		 retrieve().bodyToMono(String.class).block();
		 
		//RestTemplate restTemplate = new RestTemplate();
	//ResponseEntity<String> entity =	restTemplate.exchange(URL, HttpMethod.GET, null, String.class);
	
	System.out.println(response);
		String msg = "WELCOME TO BLR" + response;
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/detail")
	public ResponseEntity<String> getDetails(){
		String msg = "WELCOME TO BLR SOCGEN";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/register")
	public ResponseEntity<String> registerDetails(){
		String msg = "WELCOME TO SOCGEN && ReGISTER TOBLR SOCGEN";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}

package in.com.controller;

import java.util.Random;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class Controller {

	@CrossOrigin(origins = "http://localhost:6666")
	@GetMapping("/home")
	public ResponseEntity<String> getHomePage(){
		String msg = "WELCOME TO SOCGEN";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/detail")
	public ResponseEntity<String> getDetails(){
		String msg = "WELCOME TO BLR SOCGEN";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
	@GetMapping("/balance")
	public ResponseEntity<Integer> BalanceDetails(){
		Random r = new Random();
		Integer i= r.nextInt();
		return new ResponseEntity<Integer>(i,HttpStatus.OK);
	}
	
	@PostMapping("/balances")
	public ResponseEntity<Integer> getBalanceDetails(){
		Random r = new Random();
		Integer i= r.nextInt();
		return new ResponseEntity<Integer>(i,HttpStatus.OK);
	}
	
	@GetMapping("/register")
	public ResponseEntity<String> registerDetails(){
		String msg = "WELCOME TO SOCGEN && ReGISTER TOBLR SOCGEN";
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}

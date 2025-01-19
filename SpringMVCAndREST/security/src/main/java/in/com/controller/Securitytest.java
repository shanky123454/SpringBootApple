package in.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/bank")
public class Securitytest {


	    @GetMapping("/home")
	    public ResponseEntity<String> getHomePage(){
	        String res= "welcome to sbi";
	        return  new ResponseEntity<>(res,HttpStatus.OK);
	    }

	    
	    @GetMapping("/balance")
	    public ResponseEntity<String> getBalance(){
	        String res= "welcome to sbi"+ " "+ "balance is $20000";
	        return  new ResponseEntity<>(res,HttpStatus.OK);
	    }

	    @GetMapping("/show")
	    public ResponseEntity<String> showAllCustomer(){
	        String res= "welcome to sbi"+" "+ "Shashank" +" "+ "ritu";
	        return  new ResponseEntity<>(res,HttpStatus.OK);
	    }


	}



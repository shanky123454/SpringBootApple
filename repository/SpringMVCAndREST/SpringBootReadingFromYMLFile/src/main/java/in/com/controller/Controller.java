package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.config.Config;
import in.com.prop.Prop;

@RestController
@RequestMapping(value = "/yml")
public class Controller {

	@Autowired
	public Config config;
	
	@GetMapping(value = "/greet")
	public ResponseEntity<String> getResponse(){
		String res = config.getProperties().get(Prop.greet_Msg);
		return  new ResponseEntity<String>(res,HttpStatus.OK);
	}
	
	@GetMapping(value = "/test")
	public ResponseEntity<String> getResponse1(){
		String res1 = config.getProperties().get(Prop.test_Msg);
		return  new ResponseEntity<String>(res1,HttpStatus.OK);
	}
	
	@GetMapping(value = "/wel")
	public ResponseEntity<String> getResponse2(){
		String res2 = config.getProperties().get(Prop.welcome_Msg);
		return  new ResponseEntity<String>(res2,HttpStatus.OK);
	}
}

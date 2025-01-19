package in.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ControllerClass {
	
	@GetMapping("/normal")
	public String welcome() {
	return "<h1>Welcome to iNeuron Family</h1>";
	}
	
	@GetMapping("/admin")
	public String adminProcess() {
	return "<h1>Welcome Admin</h1>";
	}
	
	@GetMapping("/user")
	public String userProcess() {
	return "<h1>Welcome User</h1>";
	}


}

package in.com.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class HelloWorldController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping({ "/hello" })
	public String firstPage() {
		return "Hello World ADMIN";
	}
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping({ "/helloo" })
	public String firsttPage() {
		return "Hello World USER";
	}

}

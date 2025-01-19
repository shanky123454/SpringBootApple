package com.javainuse.controller;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class TestController {

	@GetMapping("/test")
	public String test() {
		return "Hello World";
	}
}

package com.javainuse.controller;

import java.security.Principal;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableResourceServer
public class TestController {

	@GetMapping("/validateUser")
	public Principal user(Principal user) {
		return user;
	}
}

package in.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.response.HelloServiceIntegrated;

@RestController
@RequestMapping(value = "/Hi")
public class Hi {
	
	@Autowired
	public HelloServiceIntegrated helloServiceIntegrated;

	@GetMapping(value = "/hi/{name}")  
	public String wishHiMsg(@PathVariable(value = "name") String name) {
		
		System.out.println("implementing proxyclass is:" + helloServiceIntegrated.getClass().getName());
	String response =helloServiceIntegrated.invokeHelloService(name);
		
		return "Hi"+ " " + response;
	}
}

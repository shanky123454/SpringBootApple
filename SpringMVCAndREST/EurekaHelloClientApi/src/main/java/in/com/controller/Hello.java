package in.com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Hello")
public class Hello {
	
	@GetMapping(value = "/hello/{name}")
	public String grettingMsg(@PathVariable(value = "name") String name)
	{
		return "Hello" + " "+ name; 
	}

}

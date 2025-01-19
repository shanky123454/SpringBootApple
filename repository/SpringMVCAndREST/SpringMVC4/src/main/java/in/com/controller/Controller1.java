package in.com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.com.model.Employee;

@Controller
public class Controller1 {
	
	@GetMapping("/Home")
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showForm(@ModelAttribute("emp") Employee employee) {
	return "register";
	}
	
	
	@PostMapping(value = "result")
	public String getResult(Map<String,Object> model,@ModelAttribute(name = "emp")Employee employee)
	{
		System.out.println(employee);
		model.put("emp", employee);
		return "result";
	}

}

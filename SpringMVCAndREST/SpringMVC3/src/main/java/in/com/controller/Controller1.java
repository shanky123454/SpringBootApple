package in.com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import in.com.model.Employee;

@Controller
public class Controller1 {

	
	  @RequestMapping(path = "/",method = RequestMethod.GET)
	  public String showHome()
	  { 
		  return "home"; 
	  }
	 

	@GetMapping(value = "/report")
	public String showForm() {
		return "register";
	}

	@PostMapping(value = "/report")
	public String registerEmployee(Map<String, Object> model, @ModelAttribute(name = "emp") Employee employee) {
		System.out.println(employee);
		model.put("emp", employee);
		return "result";
	}

}

package in.com.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.com.model.Employee;

@Controller
public class Controller1 {
	
	@GetMapping(value = "/report")
	public String getResult(Map<String,Object> model,
			@RequestParam(value = "eid") Integer sno,@RequestParam(value = "ename") String name)
	{
		Employee employee = new Employee(sno, name, "batsman", 90000.0);
		model.put("emp", employee);
		return "display3";
	}

}

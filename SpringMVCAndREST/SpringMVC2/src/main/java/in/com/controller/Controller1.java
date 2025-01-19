package in.com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import in.com.model.Employee;

@Controller
public class Controller1 {
	
	@GetMapping(value = "/report")
	//@ResponseBody
	public ModelAndView getResult(ModelAndView model,
			@RequestParam(value = "eid") Integer sno,@RequestParam(value = "ename") String name)
	{
		Employee employee = new Employee(sno, name, "batsman", 90000.0);
		model.addObject("emp", employee);
		model.setViewName("display3");
		return model;
	}
	
	
	
	@GetMapping(value = "/report2")
	@ResponseBody
	public Employee getResult2(@RequestParam(value = "eid") Integer sno,@RequestParam(value = "ename") String name)
	{
		Employee employee = new Employee(sno, name, "batsman", 90000.0);
		return employee;
	}
	
	
	@GetMapping(value = "/report1")
	@ResponseBody
	public Employee getResult1(ModelAndView model,
			@RequestParam(value = "eid") Integer sno,@RequestParam(value = "ename") String name)
	{
		Employee employee = new Employee(sno, name, "batsman", 90000.0);
		
		return employee;
	}

}

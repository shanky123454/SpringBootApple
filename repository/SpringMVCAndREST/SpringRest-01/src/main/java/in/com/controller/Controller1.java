package in.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Employee;

@RestController
@RequestMapping(value = "/second")
public class Controller1 {
	
	@GetMapping(value = "/first/{no}/bolo/{sal}")
	public ResponseEntity<Employee> getResult(@PathVariable(value = "no") Integer eno,
			@PathVariable(value = "sal") Double esal){
	Employee employee = new Employee(eno, "virat", "batsman", esal);
	return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
	

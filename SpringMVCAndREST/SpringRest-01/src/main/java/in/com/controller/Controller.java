package in.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import in.com.model.Employee;

@RestController
@RequestMapping(value = "/first")
public class Controller {

	@GetMapping(value = "/result")
	public ResponseEntity<Employee> getResult(@RequestParam(value = "id") Integer eid,
			@RequestParam(value = "sal") Double esal){
		Employee employee = new Employee(eid, "sachin", "batsman", esal);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
	@PutMapping(value = "/put")
	public ResponseEntity<String> getPutResult(@RequestParam(value = "id") Integer eid,
			@RequestParam(value = "sal") Double esal){
		Employee employee = new Employee(eid, "sachin", "batsman", esal);
		System.out.println(employee);
		String message = "employee totally got updated";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<String> delete(@RequestParam(value = "id") Integer eid,
			@RequestParam(value = "sal") Double esal){
		Employee employee = new Employee(eid, "sachin", "batsman", esal);
		System.out.println(employee);
		String message = "employee totally got deleted";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
}

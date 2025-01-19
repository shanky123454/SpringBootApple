package in.com.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Address;
import in.com.model.Student;

@RestController
@RequestMapping(value = "/getJson")
public class ControllerClass {
	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Student> getDetails(@PathVariable Integer id){
		
		System.out.println("student for the id :" + id);
		Student student= new Student();
		student.setId(95);
		student.setName("shashank");
		student.setCourses(new String[] {"JAVA","SPRING-BOOT","MICROSERVICES"});
		student.setPhoneNumbers(Set.of(123456,34567,345678));
		student.setFriendsNames(List.of("chacha","bantha"));
		student.setGovermentId(Map.of("addharcard", 12345678, "pancard", "DQ23456"));
		student.setAddress(new Address("INDIA", "BLR", "560066"));
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	@PostMapping(value = "/register",consumes = MediaType.ALL_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Student> setStudentDetails(@RequestBody Student student){
		
		System.out.println(student);
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	

}

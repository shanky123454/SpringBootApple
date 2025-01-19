package in.com.controller;

import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/producer")
public class ProducerController {

	@GetMapping(value = "/get")
	public ResponseEntity<Student> getStudent(){
		Student stu = getStudentObjects();
		return new ResponseEntity<>(stu,HttpStatus.OK);
	}

	
	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Student> getStudentPathVariable(@PathVariable Integer id){
		Address addr = new Address("BLR", "INDIA", 560066);
		Student s = new Student(93, "Sameer", "JAVA", addr);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getting/{id}")
	public ResponseEntity<Student> getStudentJsonData(@PathVariable Integer id){
		Address addr = new Address("BLR", "INDIA", 560066);
		Student s = new Student(01, "Bajju", "React", addr);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	
	@PostMapping(value = "/put")
	public ResponseEntity<Student> insertStudent(@RequestBody Student st){
		System.out.println(st.toString());
		return new ResponseEntity<Student>(st,HttpStatus.CREATED);
	}
	
	public static Student getStudentObjects() {
		Address addr = new Address("BLR", "INDIA", 560066);
		return new Student(95, "Shashank", "JAVA", addr);
	}
}

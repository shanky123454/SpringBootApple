package in.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Student;
import in.com.service.StudentServiceImpl;

@RestController
@RequestMapping(value = "/student")
public class Controller {
	
	@Autowired
	public StudentServiceImpl impl;

	@PostMapping(value = "/insert")
	public ResponseEntity<Student> insertStudent(@RequestBody Student std){
	Student student =	impl.addStudent(std);
		return new ResponseEntity<>(student,HttpStatus.OK);
 }
	 @PutMapping(value = "/update/{sid}")
	public ResponseEntity<String> updateStudent(@RequestBody Student std,@PathVariable(value = "sid") Integer id){
	String s =impl.updateStudent(std, id);
		return new ResponseEntity<>(s,HttpStatus.OK);
	}
	 
	 @GetMapping(value = "/get/{sid}")
		public ResponseEntity<Student> getOneStudent(@PathVariable(value = "sid") Integer id){
		Student s =impl.getOneStudent(id);
			return new ResponseEntity<>(s,HttpStatus.OK);
		}
	 
	 @DeleteMapping(value = "/delete/{sid}")
		public ResponseEntity<String> deleteStudent(@PathVariable(value = "sid") Integer id){
	String result=	impl.deletestudent(id);
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
	 
	 @GetMapping(value = "/getAll")
		public ResponseEntity<List<Student>> getAllStudent(){
	List<Student> list = impl.getAllStudent();
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
}

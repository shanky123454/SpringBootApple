package in.com.controller;

import java.util.ArrayList;
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

import in.com.model.Cricketer;
import in.com.service.IServiceImpl;

@RestController
@RequestMapping(value = "/cricketer")
public class Controller {

	@Autowired
	public IServiceImpl impl;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> registerCricketer(@RequestBody Cricketer cricketer){
	String result =	impl.register(cricketer);
	return new ResponseEntity<>(result,HttpStatus.OK); 
	}
	
	@GetMapping(value = "/findAll")
	public ResponseEntity<List<Cricketer>> getAllCricketers(){
		List<Cricketer> cricketerlist= new ArrayList<Cricketer>();
		cricketerlist=impl.findall();
		return  new ResponseEntity<>(cricketerlist,HttpStatus.OK);
	}
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<Cricketer> getByid( @PathVariable Integer id){
	Cricketer cricketer =	impl.findById(id);
	return new ResponseEntity<>(cricketer, HttpStatus.OK);
	}
	
	@PutMapping(value = "/update")
	public ResponseEntity<String> updateById(@RequestBody Cricketer cricketer){
	String result =	impl.updateById(cricketer);
	return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		String result = impl.deleteById(id);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
}

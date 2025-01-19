package in.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Books;

@RestController
@RequestMapping(value = "/hateos")
public class JavahateosDemo {

	@GetMapping(value = "/books/{id}", produces = "application/json")
	public ResponseEntity<Books> getBooksById (@PathVariable Integer id){
	
		Books books = new Books("12", "java", "SHASHANK", 456.66f);
	Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(JavahateosDemo.class).
				getAllBooks())
				.withRel("Allbooks");
	
				books.add(link);	
		return new ResponseEntity<>(books, HttpStatus.OK);
	}
	
	@GetMapping(value = "/Allbooks")
	public List<Books> getAllBooks(){
		List<Books> booklist = new ArrayList<>();
		Books books1 = new Books("13", "dbms", "SHASHANK", 123.56f);
		Books books2 = new Books("14", "cn", "RITU", 445.23f);
		Books books3 = new Books("15", "os", "SAMEER", 989.5f);
		
		booklist.add(books1);
		booklist.add(books2);
		booklist.add(books3);
		
		return booklist;
		

	}
}

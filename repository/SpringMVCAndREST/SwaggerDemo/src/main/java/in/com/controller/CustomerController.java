package in.com.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.com.model.Customer;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/customer/get")
public class CustomerController {

	    @GetMapping("/{id}")
	    @ApiOperation(value = "Getting the customer based on id")
	    public ResponseEntity<Customer> get(@PathVariable final Long id) {
	    	Customer customer = new Customer(1, "shashank", 345.564f);
	        return ResponseEntity.ok(customer);
	    }

	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Customer> delete(@PathVariable final Long id) {
	    	Customer customer = new Customer(2, "shashank raj", 34.8f);
	    	System.out.println("customer deleted");
	        return ResponseEntity.ok(customer);
	    }

}

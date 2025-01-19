package in.com.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.com.dao.Customer;
import in.com.dao.Employee;
import in.com.dao.Person;

@Component
public class EmployeeRunner implements CommandLineRunner {
	
	@Autowired
	public Employee employee;
	
	@Autowired
	public Person person;
	
	@Autowired
	public Customer customer;

	@Override
	public void run(String... args) throws Exception {
		employee.getEmployee();
		System.out.println();
		
		employee.insertEmployee();
		System.out.println();
		
		person.getPerson();
		System.out.println();
		
		person.updatePerson();
		System.out.println();
		
		person.helloPerson(95,"shahsank");
		System.out.println();
		
		int result = customer.getCustomer();
		System.out.println(result);
		
		customer.insertCustomer();
		
	}

}

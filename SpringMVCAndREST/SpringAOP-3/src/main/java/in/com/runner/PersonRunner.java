package in.com.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.com.dao.Person;

@Component
public class PersonRunner implements CommandLineRunner {


	@Autowired
	public Person person;
	
	@Override
	public void run(String... args) throws Exception {
		
		person.getPerson();
		System.out.println("*****************");
		
		person.updatePerson();
		System.out.println("********************");
		

	}

}

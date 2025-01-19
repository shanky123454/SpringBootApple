package in.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.IserviceImpl.IServiceImpl;
import in.com.model.person.Person;
import in.com.model.phone.PhoneNumbers;

@SpringBootApplication
public class SpringBootDataJpaBiDirectionalAssociationApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	 SpringApplication.run(SpringBootDataJpaBiDirectionalAssociationApplication.class, args);
IServiceImpl impl =	applicationContext.getBean(IServiceImpl.class);

Person person = new Person();
person.setPname("ritu raj");
person.setPaddress("dighi");

PhoneNumbers numbers = new PhoneNumbers();
numbers.setPhoneNo(12345667L);
numbers.setProvider("airtel");
numbers.setType("personal");
numbers.setPerson(person);

PhoneNumbers numbers1 = new PhoneNumbers();
numbers1.setPhoneNo(123456677867L);
numbers1.setProvider("jio");
numbers1.setType("home");
numbers1.setPerson(person);


// Set<PhoneNumbers> numSet = new HashSet<>();
//numSet.add(numbers1);
//numSet.add(numbers);

ArrayList<PhoneNumbers> numSet = new ArrayList<>();
numSet.add(numbers1);
numSet.add(numbers);

// person.setNumbers(numSet);

  // String res = impl.save(person);

		String res =impl.savePhoneNumbers(numSet);
   System.out.println(res);
  // impl.deleteByPersonId(1);
	}

}

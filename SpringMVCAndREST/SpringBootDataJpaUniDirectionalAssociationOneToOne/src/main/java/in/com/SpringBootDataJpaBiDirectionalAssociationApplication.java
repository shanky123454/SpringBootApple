package in.com;

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
//numbers.setPerson(person);

person.setNumbers(numbers);
   String res = impl.save(person);
   impl.fetchPerson();
   System.out.println(res);
	}

}

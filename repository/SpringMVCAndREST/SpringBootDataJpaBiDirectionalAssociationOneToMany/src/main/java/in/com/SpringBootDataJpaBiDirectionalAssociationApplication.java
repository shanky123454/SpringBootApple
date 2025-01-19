package in.com;

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
Person person = new Person("SHASHANK", "BLR");

PhoneNumbers numbers = new PhoneNumbers(12345l,"jio", "office");
PhoneNumbers numbers2 =  new PhoneNumbers(345556l, "airtel", "home");
 numbers.setPerson(person);
 numbers2.setPerson(person);
Set<PhoneNumbers> set = Set.of(numbers, numbers2);
person.setNumbers(set);

	impl.save(person);
	impl.fetchPerson();
	impl.fetchPnos();
	}

}

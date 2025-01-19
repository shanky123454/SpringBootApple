package in.com;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.IserviceImpl.IServiceImpl;
import in.com.model.MarutiSuzukiCar.MarutiSuzukiCar;
import in.com.model.person.Customer;

@SpringBootApplication
public class SpringBootDataJpaBiDirectionalAssociationApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	 SpringApplication.run(SpringBootDataJpaBiDirectionalAssociationApplication.class, args);
IServiceImpl impl =	applicationContext.getBean(IServiceImpl.class);

MarutiSuzukiCar car = new MarutiSuzukiCar("black", LocalDateTime.now());

Customer person1 = new Customer("SHASHANK", "BLR");
Customer person2 = new Customer("SAMEER", "MZP");

List<Customer> personlist = List.of(person2, person1);
person1.setCar(car);
person2.setCar(car);

car.setPerson(personlist);


 impl.save(car); 
// impl.save(personlist);
// impl.fetchCars(); 
// impl.fetchPerson();
  
 //impl.deleteCar(2);
 

//  impl.deleteAllCustomersByCarId(2);



	}

}

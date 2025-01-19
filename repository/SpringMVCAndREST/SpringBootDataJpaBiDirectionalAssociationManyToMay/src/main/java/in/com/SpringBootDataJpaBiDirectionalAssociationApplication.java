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

MarutiSuzukiCar car1 = new MarutiSuzukiCar("black", LocalDateTime.now());
MarutiSuzukiCar car2 = new MarutiSuzukiCar("white", LocalDateTime.now());

List<MarutiSuzukiCar> list = List.of(car1,car2);


Customer person1 = new Customer("SHASHANK", "BLR");
Customer person2 = new Customer("SAMEER", "MZP");
Customer person3 = new Customer("Bajju", "Motihari");


List<Customer> personlist = List.of(person2, person1,person3);
person1.setCar(list);
person2.setCar(list);
person3.setCar(list);


car1.setPerson(personlist);
car2.setPerson(personlist);

 //impl.save(personlist);
 //impl.save1(list);
 
 impl.fetchCarsById(1);
 impl.fetchPersonById(1);
 
// impl.save(personlist);
// impl.fetchCars(); 
// impl.fetchPerson();
  
 //impl.deleteCar(2);
 

//  impl.deleteAllCustomersByCarId(2);



	}

}

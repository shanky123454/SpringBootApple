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

Customer person1 = new Customer("SHASHANK", "BLR");

MarutiSuzukiCar car = new MarutiSuzukiCar();
car.setPerson(person1);
car.setColor("black");
car.setMfgYear(LocalDateTime.now());

MarutiSuzukiCar car1 = new MarutiSuzukiCar();
car1.setPerson(person1);
car1.setColor("red");
car1.setMfgYear(LocalDateTime.now());


//Customer person2 = new Customer("SAMEER", "MZP");
//List<Customer> personlist = List.of(person2, person1);
//person1.setCar(car);
//person2.setCar(car);

List<MarutiSuzukiCar> carlist = List.of(car,car1);

 impl.saveCars(carlist); 
// impl.save(personlist);
// impl.fetchCars(); 
// impl.fetchPerson();
  
 //impl.deleteCar(2);
 

//  impl.deleteAllCustomersByCarId(2);



	}

}

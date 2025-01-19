package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.dto.CustomerDto;
import in.com.service.CustomerImplClass;

@SpringBootApplication
public class SpringBootMongoDbDemoApplication {

	public static void main(String[] args) {
   ApplicationContext applicationContext =	SpringApplication.run(SpringBootMongoDbDemoApplication.class, args);
  CustomerImplClass customerImplClass= applicationContext.getBean("service",CustomerImplClass.class);
  customerImplClass.getCustomer().forEach(System.
		  out::println);
 //   customerImplClass.registerCustomer(new CustomerDto(7, "pucchu", new String[] {"bounsi","delhi"}, new Long[] {89077l,3456l}));
    
  //  customerImplClass.getByPhone(new Long[] {89077L,3456L}).forEach(System.out::println);
    customerImplClass.getByCname(new String[] {"pucchu","kacchi"}).forEach(System.out::println);
    System.out.println("*************************");
    customerImplClass.getByCid(new Integer[] {7,6}).forEach(System.out::println);

	}

}

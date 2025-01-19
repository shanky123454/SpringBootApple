package in.ineuron;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.ineuron.service.ICustomerMgmtService;

@SpringBootApplication
public class DaoSpringDataJpaMongoDbCrudAppApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(DaoSpringDataJpaMongoDbCrudAppApplication.class, args);
		
		ICustomerMgmtService service = applicationContext.getBean(ICustomerMgmtService.class);
	
		//System.out.println(service.registerCustomer(new CustomerDTO(18, "kohli", 110.0f)));
		//service.findAllCustomers().forEach(System.out::println);
		
		//System.out.println(service.removeCustomer("6440ab5b4bdaad5dc8a2e59e"));
		
		//System.out.println(service.registerCustomer(new CustomerDTO(3, "nitinmanjunath", 550.0f)));
		
		// service.registerCustomer(new CustomerDTO(18, "kohli", 450.05f, "RCB", 999555776L));
		
		//service.fetchCustomerByBillAmount(340.50f, 500.05f).forEach(System.out::println);
		
		service.fetchCustomerByUsingAddressAndHavingMobileNo("MI","CSK").forEach(System.out::println);
		((ConfigurableApplicationContext) applicationContext).close();		
	}
}

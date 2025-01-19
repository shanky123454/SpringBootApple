package in.com;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.com.DTO.EmployeeDTO;
import in.com.service.CustomerServiceImplClass;


@SpringBootApplication
public class SpringBootProject2Application {

	public static void main(String[] args) {
	
	ApplicationContext factory =	SpringApplication.run(SpringBootProject2Application.class, args);
		
		Object obj  = factory.getBean("serviceimpl",CustomerServiceImplClass.class);
		CustomerServiceImplClass customerServiceImplClass = (CustomerServiceImplClass)obj;
	
	try {
	       
	       List<EmployeeDTO> dtos2 = customerServiceImplClass.getEmployeesDetailsById(1,2);
	       System.out.println(dtos2);
	       

	        customerServiceImplClass.getEmployeesDetailsById1(2);
	       
	       
	      
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) factory).close();
		Runnable r = null;
		Thread t = new Thread(r);
		
	}


}

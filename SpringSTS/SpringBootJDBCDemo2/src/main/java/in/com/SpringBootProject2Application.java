package in.com;

import java.util.List;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import in.com.service.CustomerServiceImplClass;


@SpringBootApplication
public class SpringBootProject2Application {

	public static void main(String[] args) {
	
	ApplicationContext factory =	SpringApplication.run(SpringBootProject2Application.class, args);
		
		Object obj  = factory.getBean("serviceimpl",CustomerServiceImplClass.class);
		CustomerServiceImplClass customerServiceImplClass = (CustomerServiceImplClass)obj;
	
	try {
	      int result=	customerServiceImplClass.getCustomerCount();
	      System.out.println(result);
	      
	      String empname= customerServiceImplClass.getEmployeeNameById(2);
	      System.out.println(empname);
	      
	      List<Map<String, Object>> dtos = customerServiceImplClass.getEmployeesDetailsById(2,4);
	       dtos.forEach(System.out::print);
	       
	      Map<String, Object> dtos2 = customerServiceImplClass.getEmployeeDetailsById(6);
	       System.out.println(dtos2);
	       
	       //Integer i1 = customerServiceImplClass.insertEmployee(7, "chacha", "peon", 76688.8f, 6, 22);
	      // System.out.println(i1);
	       
	       Integer integer = customerServiceImplClass.updateSalary(1000, "manager");
	       System.out.println(integer);
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) factory).close();
	}


}

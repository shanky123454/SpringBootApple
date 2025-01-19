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
	      int result=	customerServiceImplClass.getCustomerCount();
	      System.out.println(result);
	      
	      String empname= customerServiceImplClass.getEmployeeNameById(2);
	      System.out.println(empname);
	      
	      List<List<EmployeeDTO>> dtos = customerServiceImplClass.getEmployeesDetailsById(2,4);
	      int size = dtos.size();
	      System.out.println(size);
	       dtos.forEach(System.out::print);
	       
	       List<EmployeeDTO> dtos2 = customerServiceImplClass.getEmployeeDetailsById(6,1);
	       System.out.println(dtos2);
	       
//	       Integer i1 = customerServiceImplClass.insertEmployee(66, "bhagya", "sweeper", 76688.8f, 6, 22);
//	       System.out.println(i1);
	       
	       Integer integer = customerServiceImplClass.updateSalary(1000, "manager");
	       System.out.println(integer);
	       
	       List<Map<String,Object>> list = customerServiceImplClass.getEmployeeListByJob("po","manager");
	       list.forEach(System.out::println);
	       
	       List<EmployeeDTO> dtos3 = customerServiceImplClass.getEmployeeListByUsingResultSetExtractor(4, 5);
	       dtos3.forEach(System.out::println);
	       
	       List<EmployeeDTO> dtos4 = customerServiceImplClass.getEmployeeListByUsingResultSetExtractor1(3, 5);
	       dtos4.forEach(System.out::println);
	       
	       List<EmployeeDTO> dtos5 = customerServiceImplClass.getEmployeeDetailsByUsingRowCallBackHandler(7,8);
	       dtos5.forEach(System.out::println);
	       
	       
		} catch (Exception e) {
			e.printStackTrace();
		}
		((ConfigurableApplicationContext) factory).close();
		Runnable r = null;
		Thread t = new Thread(r);
		
	}


}

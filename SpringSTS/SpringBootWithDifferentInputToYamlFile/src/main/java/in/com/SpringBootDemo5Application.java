package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.employee.Employee;

@SpringBootApplication
public class SpringBootDemo5Application {

	public static void main(String[] args) {
	ApplicationContext applicationContext=	SpringApplication.run(SpringBootDemo5Application.class, args);
	Employee employee = applicationContext.getBean("employee",Employee.class);
	System.out.println(employee);
	}

}

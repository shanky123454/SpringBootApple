package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.DTO.EmployeeDTO;
import in.com.DTO.EmployeeDTO2;

@SpringBootApplication
public class SpringBootDemo41Application {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringBootDemo41Application.class, args);
		EmployeeDTO2 dto = applicationContext.getBean("employeeDTO2",EmployeeDTO2.class);
		System.out.println(dto);
	}

}

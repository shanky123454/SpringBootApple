package in.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.service.IStudentService;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringDataJpa1Application.class, args);
IStudentService iStudentService =	applicationContext.getBean(IStudentService.class);
	iStudentService.fetchEmployeeDTOById(55,77).forEach(
			System.out::println);
	}

}

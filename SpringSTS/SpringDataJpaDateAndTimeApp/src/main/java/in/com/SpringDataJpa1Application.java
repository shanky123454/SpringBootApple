package in.com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.com.BO.EmployeeDTO;
import in.com.service.IStudentService;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringDataJpa1Application.class, args);
IStudentService iStudentService =	applicationContext.getBean(IStudentService.class);
EmployeeDTO dto = new EmployeeDTO();
dto.setId(95);
dto.setName("Shashank");
dto.setAge(23);
dto.setDob(LocalDate.of(2000, 10, 14));
dto.setDoj(LocalDateTime.of(2022, 8, 4, 12, 34));
dto.setDom(LocalTime.now());
	iStudentService.Insert(dto);
	}

}

package in.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;

import in.com.BO.StudentBO;
import in.com.DTO.StudentDTO;
import in.com.service.IStudentService;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
	ApplicationContext applicationContext =	SpringApplication.run(SpringDataJpaApplication.class, args);
		 IStudentService service =  applicationContext.getBean(IStudentService.class);
	      StudentDTO dto = null;
	      
	      while(true)
	      {
	    	  try {
	    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	    System.out.println("1. findAll");
				System.out.println("2. findAllbypagination");
				System.out.println("3. EXIT");
				
				System.out.print("Your Option :: [1,2,3]:: ");
				
				Integer option = Integer.parseInt(br.readLine());
								
				switch(option)
				{
				case 1 :
				List<StudentBO> bo =(List<StudentBO>) service.findAll(false, "sage","sid");
				bo.forEach(System.out::println);
				break;
				
				case 2:
				Page<StudentBO> stdpage =service.findAllbypagination(1, 2, true, "sage");
				stdpage.forEach(System.out::println);
				break;
				
				case 3:
					service.fetchDetailsByPagination(2);
					break;
				
				default:
					System.out.println("enter the valid input");
					System.exit(0);
				}
	      }catch(Exception e)
	    	  {
	    	  	e.printStackTrace();
	    	  }finally {
	    	      ((ConfigurableApplicationContext)applicationContext).close();
	           }
	      }
	}

}

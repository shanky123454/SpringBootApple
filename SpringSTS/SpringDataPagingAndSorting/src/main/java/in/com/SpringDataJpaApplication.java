package in.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import in.com.BO.StudentBO;
import in.com.DTO.StudentDTO;
import in.com.Type.ResultView;
import in.com.dynamic.ResultView2;
import in.com.dynamic.ResultView3;
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
					
				case 4:
				List<StudentBO> book =service.findBysname("shashank raj");
				book.forEach(b ->{
					System.out.println(b);
				});
				break;
				
				case 5:
					List<StudentBO> book1 =service.findBysnameIn("shashank raj","golu");
					book1.forEach(b ->{
						System.out.println(b);
					});
					break;
					
				case 6:
					List<StudentBO> book2 =service.findBysidGreaterThanEqual(12);
					book2.forEach(b ->{
						System.out.println(b);
					});
					break;
					
				case 7:
					List<StudentBO> book3 =service.findBysidGreaterThanEqualOrderBySageDesc(12);
					book3.forEach(b ->{
						System.out.println(b);
					});
					break;
					
				case 8:
					List<StudentBO> book4 =service.findBySageIsIn(56,77);
					book4.forEach(b ->{
						System.out.println(b);
					});
					break;
					
				case 9:
					List<ResultView> book5 =service.findBySidIsIn(12,13);
					book5.forEach(b ->{
						System.out.println(b.getsaddress() + " " + b.getsid());
					});
					break;
					
				case 10:
					List<ResultView3> book6 =service.findBySname(ResultView3.class,"shashank raj");
					book6.forEach(b ->{
						System.out.println(b.getSage() + " " + b.getSid()+" " + b.getSname());
					});
					break;
					
				case 11:
					List<ResultView2> book7 =service.findBySid(ResultView2.class,11);
					book7.forEach(b ->{
						System.out.println(b.getSaddress()+ " " + b.getSid());
					});
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

package in.com.chacha;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import in.com.DTO.StudentDTO;
import in.com.config.AppConfig;
import in.com.service.IStudentService;

public class MainApp 
{
    public static void main( String[] args )
    {
      ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
      IStudentService service =  applicationContext.getBean(IStudentService.class);
      StudentDTO dto = null;
      
      while(true)
      {
    	  try {
    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    System.out.println("1. CREATE");
			System.out.println("2. READ BY ID");
			System.out.println("3. READ ALL RECORDS");
			System.out.println("4. UPDATE");
			System.out.println("5. DELETE WITH RESPECT TO ID");
			System.out.println("6. DELETE WITH RESPECT TO BEAN");
			System.out.println("7. EXIT");
			
			System.out.print("Your Option :: [1,2,3,4,5,6,7]:: ");
			
			Integer option = Integer.parseInt(br.readLine());
			
			String name=null,age=null,address=null,id=null;
			
			switch(option)
			{
			case 1 : System.out.print("Enter the name:: ");
			name = br.readLine();

			System.out.print("Enter the age:: ");
			age = br.readLine();

			System.out.print("Enter the address:: ");
			address = br.readLine();

			dto = new StudentDTO();
			dto.setSname(name);
			dto.setSage(Integer.parseInt(age));
			dto.setSaddress(address);

			int rowAffected = service.insert(dto);
			System.out.println("Id of the record saved is :: " + rowAffected);

			break;
			
			case 2: System.out.println("enter the id to delete::");
				id=br.readLine();
				service.delete(Integer.parseInt(id));
				break;
			case 3: System.out.println("enter the id to be searched");
						id = br.readLine();
					StudentDTO dto1 =	service.getStudent(Integer.parseInt(id));
					System.out.println(dto1);
					break;
			case 4:
				List<StudentDTO> dto2 =service.getAllStudents();
				dto2.forEach(System.out::println);
				break;
			case 5: 
			System.out.print("Enter the name:: ");
			name = br.readLine();

			System.out.print("Enter the age:: ");
			age = br.readLine();

			System.out.print("Enter the address:: ");
			address = br.readLine();
			
			System.out.println("enter the id of the student");
			id= br.readLine();

			dto = new StudentDTO();
			dto.setSid(Integer.parseInt(id));
			dto.setSname(name);
			dto.setSage(Integer.parseInt(age));
			dto.setSaddress(address);
			
			service.update(dto);
			break;
			case 6: 
				System.out.print("Enter the name:: ");
				name = br.readLine();

				System.out.print("Enter the age:: ");
				age = br.readLine();

				System.out.print("Enter the address:: ");
				address = br.readLine();
				
				System.out.println("enter the id of the student");
				id= br.readLine();

				dto = new StudentDTO();
				dto.setSid(Integer.parseInt(id));
				dto.setSname(name);
				dto.setSage(Integer.parseInt(age));
				dto.setSaddress(address);
				
				service.delete(dto);
				break;
			default:
				System.out.println("Plz enter the option like 1,2,3,4,5 for operation");
				break;
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

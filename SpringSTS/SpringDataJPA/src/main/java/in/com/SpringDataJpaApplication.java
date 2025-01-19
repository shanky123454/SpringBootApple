package in.com;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

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
	    	    System.out.println("1. CREATE");
				System.out.println("2. READ BY ID");
				System.out.println("3. READ ALL RECORDS");
				System.out.println("4. UPDATE");
				System.out.println("5. DELETE WITH RESPECT TO ID");
				System.out.println("6. DELETE WITH RESPECT TO BEAN");
				System.out.println("7. Update in Btach");
				System.out.println("10 Get total Student");
				System.out.println("8. EXIT");
				
				System.out.print("Your Option :: [1,2,3,4,5,6,7,8]:: ");
				
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
					Iterable<StudentDTO> dto2 =service.getAllStudents();
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
					
				case 7:
					StudentDTO dto3 = new StudentDTO();
					dto3.setSname("rupam");
					dto3.setSage(51);
					dto3.setSaddress("dighi");
					
					StudentDTO dto4 = new StudentDTO();
					dto4.setSname("aaroop");
					dto4.setSage(13);
					dto4.setSaddress("dighi");
					List<StudentDTO> sdto = new ArrayList<StudentDTO>();
					sdto.add(dto4);
					sdto.add(dto3);
				Iterable<StudentBO> boo =service.insertInBatch(sdto);
				boo.forEach((StudentBO) -> {
					System.out.println(StudentBO.getSid());
				});
				
				case 8: System.out.println("enter the id :");
				id = br.readLine();
			   boolean bool =	service.existsById(Integer.parseInt(id));
			   System.out.println(bool);
			   
			   
				case 9 : 
				List<Integer> list = List.of(1,4,5,6,7,8);
				List<StudentDTO> dtos =	(List<StudentDTO>) service.findAllById(list);
				dtos.forEach(System.out::println);
				
				case 10:
				  Long result = service.totalStudent();
				  System.out.println(result);
				  
				case 11:
					List<Integer> list1 = List.of(6,8);
					 service.deleteAllById(list1);
					 
				case 12:
					 List<Integer> list2 = List.of(9,10);
					 service.deleteAllById1(list2);
				
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

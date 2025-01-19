package in.main.controller;

import java.util.Scanner;
import in.main.dto.Student;
import in.main.service.IStudentService;
import in.main.servicefactory.StudentServiceFactory;

public class Test {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		while(true)

		{
			System.out.println("1. insert");
			System.out.println("2. search");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.println("enter your choice: 1/2/3/4/5");
			String option = sc.nextLine();
			
			switch(option)
			{
			case "1": insert();
						break;
			case "2": search();
				break;
				
			case "3": update();
						break;
						
			case "4": delete();
				break;
			case "5": System.out.println("thanks for using the application");
			            System.exit(0);
			
			default: System.out.println("enter the correct input to perform crud operation");
			break;
			}
			
		}
	}


	private static void update() {
		System.out.println("enter the id of the student to search");
        Scanner sc = new Scanner(System.in);
        String  sid = sc.nextLine();
		
		IStudentService studentservice = StudentServiceFactory.getstudentservice();
		   Student std =studentservice.searchStudent(Integer.parseInt(sid));
		    Student newstd = new Student();
		   if(std!=null)
		   {
			   
			   System.out.println("student id is ::" + std.getId());
			   newstd.setId(std.getId());
			   
			System.out.println("student oldname is :" + std.getName()+ " enter the new name ::" );
			  String newname = sc.nextLine();
			   
			   if(newname=="" || newname.equalsIgnoreCase(std.getName()))
			   {
				   newstd.setName(std.getName());
			   }
			   else {
				   newstd.setName(newname);
			   }
		  
			  
			System.out.println("student oldage is :" + std.getAge()+ " enter the new age ::" );
			String newage = sc.nextLine();
			   

			    
			    if(newage=="" || newage.equals(Integer.toString(std.getAge())))
			   {
				   newstd.setAge(std.getAge());
			   }
			    else {
			    	newstd.setAge(Integer.parseInt(newage));
			    }
		   }
		   
			
			    String status =studentservice.updateStudent(newstd);
			    if(status.equalsIgnoreCase("success"))
				   {
					   System.out.println("succesfully updated");
				   }
				   else
					   System.out.println("not updated");			   
		
		     }

	public static void search() {
	           System.out.println("enter the id of the student to search");
	           Scanner sc = new Scanner(System.in);
                int sid = sc.nextInt();
		IStudentService studentservice = StudentServiceFactory.getstudentservice();
		   Student std =studentservice.searchStudent(sid);
		   
		   if(std!=null)
		   {
			   System.out.println(std);
			   System.out.println("SID \t SNAME\t SAGE");
			   System.out.println(std.getId() +"\t" + std.getName()+"\t" + std.getAge());
			   
		   }
		   else {
			   System.out.println("record not found for the given id::" +sid);
		   }
		  
	}
		
		//=========== for deletion======================================================
		
		public static void delete() 
		{
			System.out.println("enter the id of the student to delete");
	           Scanner sc = new Scanner(System.in);
                      int sid = sc.nextInt();
		     IStudentService studentservice = StudentServiceFactory.getstudentservice();
	         String std =studentservice.deleteStudent(sid);
	             if(std.equalsIgnoreCase("success"))
	                {
		                     System.out.println("succesfully deleted");
	                  }
	            else
	                {
		                System.out.println("not available for deletion");
	                }
     }
	

		//============= for adding ====================================================
		
		public static void insert()
		{
			System.out.println("enter the id of the student");
	           Scanner sc = new Scanner(System.in);
               int sid = sc.nextInt();
		System.out.println("enter the name of the student");
		String name = sc.next();
		System.out.println("enter the age of the student");
		int age = sc.nextInt();
//		StudentServiceFactory ssf =  new StudentServiceFactory();
//		IStudentService studentservice = ssf.getstudentservice(); // not recommended
		
		
		IStudentService studentservice = StudentServiceFactory.getstudentservice();
		   String std =studentservice.addStudent(sid, name, age);
		   if(std.equalsIgnoreCase("success"))
			   {
				   System.out.println("succesfully inserted");
			   }
			   else
				   System.out.println("not inserted");			   

     }
}
		
		
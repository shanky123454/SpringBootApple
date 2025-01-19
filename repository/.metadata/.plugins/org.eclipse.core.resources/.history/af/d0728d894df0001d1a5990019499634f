package in.main.servicefactory;

import in.main.service.IStudentService;
import in.main.service.IStudentServiceImpl;

//THIS CLASS IS USED FOR CREATING IStudentService IMPLEMENTING class OBJECT
public class StudentServiceFactory {

	public static IStudentService studentservice =null;
	
	private StudentServiceFactory()
	{

	}
	
	public static IStudentService getstudentservice()
	{
		if(studentservice==null)
		{
			studentservice = new IStudentServiceImpl();
		}
		return studentservice;
	}
}

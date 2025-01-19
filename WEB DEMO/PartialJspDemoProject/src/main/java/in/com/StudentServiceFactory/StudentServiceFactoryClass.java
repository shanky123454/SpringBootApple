package in.com.StudentServiceFactory;

import in.com.service.IStudentService;
import in.com.service.IStudentServiceImplClass;

public class StudentServiceFactoryClass {

	public  static IStudentService Istd = null;
	 
	 private StudentServiceFactoryClass()
	 {
		 
	 }
	 
	 public static IStudentService getService()
	 {
		 if(Istd==null)
		 {
			 Istd = new IStudentServiceImplClass();
			
		 }
		 return Istd;
	 }
}

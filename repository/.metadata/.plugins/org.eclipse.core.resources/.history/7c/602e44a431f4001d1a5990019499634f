package in.main.daofactory;

import in.main.persistence.IStudentDao;
import in.main.persistence.IStudentDaoImpl;


// THIS CLASS IS USED FOR CREATING IStudentDao IMPLEMENTING class OBJECT
public class StudentDaoFactory {

	public static IStudentDao studentdao = null;
	
	private StudentDaoFactory()
	{
		
	}
	
	public static IStudentDao getStudentDao()
	{
		if(studentdao==null)
		{
			studentdao = new IStudentDaoImpl();
		}
		return studentdao;
	}
}

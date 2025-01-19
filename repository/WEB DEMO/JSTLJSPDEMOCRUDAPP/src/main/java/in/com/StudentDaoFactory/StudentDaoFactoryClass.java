package in.com.StudentDaoFactory;

import in.com.Dao.IStudentDao;
import in.com.Dao.IStudentDaoImplClass;

public class StudentDaoFactoryClass {

	 public static IStudentDao Isdao=null;
	
	private StudentDaoFactoryClass()
	{
		
	}
	
	public static  IStudentDao getDao()
	{
		if(Isdao==null)
		{
			Isdao = new IStudentDaoImplClass();
		}
		return Isdao;
	}
}

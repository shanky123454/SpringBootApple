package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;
     
public class Get {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student student=null;
		Integer id = 1;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
		 student = session.get(Student.class,id);}
		if(student!=null)
		{
		flag =true;	
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			System.out.println(student);
	     }
		else {
			System.out.println("data not present with given id" + id);
		}
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}


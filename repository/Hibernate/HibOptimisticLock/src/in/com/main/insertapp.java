package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class insertapp {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Integer std = null;
		Student student=null;
		Transaction transaction =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction = session.beginTransaction();
	    }
		  if(transaction!=null)  
		  {
	      student = new Student();
	      student.setAge(23);
	      student.setSname("ritu raj");
	      student.setSaddress("dighi");
	      
	     std= (Integer) session.save(student);
		   flag =true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println("object got saved with id" + std);}
		else {
			transaction.rollback();
			System.out.println("object not got saved with id" + std);
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

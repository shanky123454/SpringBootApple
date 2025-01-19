package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Update2 {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student student = null;
		Integer id =93;
		Transaction transaction =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
	    student = session.get(Student.class,id);
		transaction = session.beginTransaction();
	    }
		if(student!=null)
		{
		  if(transaction!=null)
			  
		  {
	     System.out.println(student); 
		 student.setSname("sam");
		 student.setAge(22);
		 student.setSaddress("goa");
		 session.update(student);
		   flag =true;
		  }
		}
	 else {
		 System.out.println("student record is not present with id" + id);
	 }
			
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println("object got updated");}
		else {
			transaction.rollback();
			System.out.println("object not got updated");
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

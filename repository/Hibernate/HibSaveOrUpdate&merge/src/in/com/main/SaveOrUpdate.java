package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class SaveOrUpdate {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student student = null;
		Integer id =90;
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
	     student.setSid(id);
		 student.setSname("bajju");
		 student.setAge(28);
		 student.setSaddress("BLR");
		 session.saveOrUpdate(student);
		   flag =true;
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

package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class HibMerge {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Student std = null;
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
	     student.setSid(1112);
		 student.setSname("RITU");
		 student.setAge(28);
		 student.setSaddress("BLR");
		std= (Student) session.merge(student);
		   flag =true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println("object got saved " + std);}
		else {
			transaction.rollback();
			System.out.println("object not got saved" + std);
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

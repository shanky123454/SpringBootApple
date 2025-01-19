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
		//Integer id =null;
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
	     student.setSid(1);
		 student.setSname("SHANKY");
		 student.setAge(28);
		 student.setSaddress("BLR");
		 session.saveOrUpdate(student);
		   flag =true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println("object got saved ");}
		else {
			transaction.rollback();
			System.out.println("object not got saved");
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Persist {

	public static void main(String[] args) {
		Session session =null;
		Transaction transaction =null;
		boolean flag = false;
	try {
		session= Util.getSession();
		if(session!=null)
		{
		 transaction = session.beginTransaction();

		}
		
		if(transaction!=null)
		{
		Student s = new Student();
		s.setAge(25);
		s.setSaddress("BLR");
		s.setSid(93);
		s.setSname("SAM");
		
		 session.persist(s);// persistence operation // persist is jpa specification method
		flag =true;
		}
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
		transaction.commit();
		}
		else {
		transaction.rollback();}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

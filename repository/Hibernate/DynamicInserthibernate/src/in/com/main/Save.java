package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Save {

	public static void main(String[] args) {
		Session session =null;
		Transaction transaction =null;
		boolean flag = false;
		Integer id = null;
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
		//s.setSaddress("BLR");
		s.setSid(95);
		s.setSname("SHASHANK RAJ");
		
		 id = (Integer)session.save(s);// persistence operation // save is hibernate specification method
		flag =true;
		}
		
		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
		transaction.commit();
		System.out.println("data got saved with id ::" + id);}
		else {
		transaction.rollback();}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

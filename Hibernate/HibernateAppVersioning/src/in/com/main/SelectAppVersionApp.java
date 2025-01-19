package in.com.main;

import org.hibernate.Session;

import org.hibernate.Transaction;
import in.com.model.Student1;
import in.com.model.StudentDetails2;
import in.com.util.Util;

public class SelectAppVersionApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
	    StudentDetails2 sd= null;
	    Transaction transaction =null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
			Student1 s = new Student1();
			s.setSid(6789);
			s.setCid(12345);
			
           sd=session.get(StudentDetails2.class, s);
           transaction = session.beginTransaction();
           sd.setStd_course("ADSA");
           session.update(sd);
		    flag=true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		if(flag==true)
		{
		    transaction.commit();
			System.out.println("student details after updation::" + sd );
	     }
		else {
		    transaction.rollback();
			System.out.println("student details not found::" +sd);
		    }

	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}
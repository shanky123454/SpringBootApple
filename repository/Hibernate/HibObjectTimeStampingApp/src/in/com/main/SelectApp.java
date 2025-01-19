package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.com.model.Student;
import in.com.model.StudentDetails;
import in.com.util.Util;

public class SelectApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
	    StudentDetails sd= null;
	    Transaction transaction =null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
			Student s = new Student();
			s.setSid(91);
			s.setCid(121);
			
           sd=session.get(StudentDetails.class, s);
           
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


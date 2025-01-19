package in.com.main;

import org.hibernate.Session;
import in.com.model.Student;
import in.com.model.StudentDetails;
import in.com.util.Util;

public class SelectApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
	    StudentDetails sd= null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
			Student s = new Student();
			s.setSid(95);
			s.setCid(121);
			
           sd=  session.get(StudentDetails.class, s);
		    flag=true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		if(flag==true)
		{
		
			System.out.println("student details are::" + sd );
	     }
		else {
		
			System.out.println("student details not found::" +sd);
		    }
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}


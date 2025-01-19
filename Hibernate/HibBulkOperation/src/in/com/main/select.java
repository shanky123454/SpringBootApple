package in.com.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.model.Student;
import in.com.util.Util;

public class select {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
	    Query<Student> query = session.createQuery("FROM in.com.model.Student");
	    List<Student> std= query.list();
	    for(Student s : std) {
	    	System.out.println(s);
		}
	    
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
	}
}

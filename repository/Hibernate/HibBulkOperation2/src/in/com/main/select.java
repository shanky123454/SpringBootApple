package in.com.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;
import in.com.model.Student;
import in.com.util.Util;

public class select {

	public static void main(String[] args) {
		Session session =null;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
	    Query<Student> query = session.createQuery("FROM in.com.model.Student");
	    List<Student> std= query.list();
//	    std.forEach(
//	    		row -> {
//	    		  for (Student obj : std) {
//				    System.out.println(obj);}
//	    		System.out.println();
//	    		});
	    for (Student student : std) {
			System.out.println(student);
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

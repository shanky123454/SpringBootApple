package in.com.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.com.util.Util;

public class select3 {

	public static void main(String[] args) {
		Session session =null;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
	  Query<String> query = session.createQuery("SELECT sname FROM in.com.model.Student WHERE sid=:id");
	  query.setParameter("id",2);
	    List<String> std= query.list();
//	    std.forEach(row -> {
//	    		  for (Object obj : row) {
//				    System.out.println(obj);}
//	    		System.out.println();
//	    		});
	    for (String student : std) {
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

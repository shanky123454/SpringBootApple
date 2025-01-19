package in.com.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.com.util.Util;

public class select2 {

	public static void main(String[] args) {
		Session session =null;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
	  Query<Object[]> query = session.createQuery("SELECT sname,sage,saddress FROM in.com.model.Student WHERE sid=:id");
	  query.setParameter("id",2);
	    List<Object[]> std= query.list();
	    std.forEach(row -> {
	    		  for (Object obj : row) {
				    System.out.println(obj);}
	    		System.out.println();
	    		});
//	    for (Object student : std) {
//			System.out.println(student);
//		}
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

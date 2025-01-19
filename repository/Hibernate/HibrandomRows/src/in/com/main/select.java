package in.com.main;

import java.util.ArrayList;
import java.util.Arrays;
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
	    Query<Student> query = session.createQuery("FROM in.com.model.Student WHERE sid IN(:id)");
//	    List<Integer> al = new ArrayList<>();  // This will also work
//	    al.add(1);
//	    al.add(2);
//	    al.add(3);
	    List<Integer> al = Arrays.asList(1,2,3);
	    query.setParameterList("id", al);
	    List<Student> std= query.list();
	     if (std != null) {
	          std.forEach(System.out::println);
		}
	     else {
	    	 System.out.println("id not found for given id:");
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

package in.com.main;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import in.com.model.Student;
import in.com.util.Util;

public class Insert {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Transaction tr= null;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
			tr=session.beginTransaction();
		Query query = session.createQuery
("INSERT into in.com.model.Student2 (sid,sname,sage,saddress) SELECT i.sid,i.sname,i.sage,i.saddress from in.com.model.Student as i WHERE i.sage>=:min");
	     query.setParameter("min",22);
	    int std= query.executeUpdate();
	          flag=true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	
	}finally {
		if(flag==true)
		{
			tr.commit();
			System.out.println("updated means inserted");
		}
		else {
			tr.rollback();
		}
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
	}
}

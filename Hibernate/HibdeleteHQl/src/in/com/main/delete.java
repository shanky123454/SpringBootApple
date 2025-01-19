package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import in.com.model.Student;
import in.com.util.Util;

public class delete {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Transaction tr= null;

	try {
		session= Util.getSession();
		if(session!=null) 
		  {
			tr=session.beginTransaction();
	    Query<Student> query = session.createQuery("DELETE FROM in.com.model.Student WHERE sid=:id");
	     query.setParameter("id",2);
	    int std= query.executeUpdate();
	     if (std == 1) {
	          System.out.println("rows affected");
	          flag=true;
		}
	     else {
	    	 System.out.println("row not updated:");
	     }
	    
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			tr.commit();
		}
		else {
			tr.rollback();
		}
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
	}
}

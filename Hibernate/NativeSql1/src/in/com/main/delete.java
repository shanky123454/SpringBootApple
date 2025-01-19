package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.com.model.Student2;
import in.com.util.Util;

public class delete {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Integer std = null;
		Student2 student=null;
		Transaction transaction =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
			transaction =session.beginTransaction();
		// NativeQuery<Student2> query = session.createSQLQuery("delete from Student2 where sid=:id");
			NativeQuery<Student2> query = session.createSQLQuery("delete from Student2 where sid=?");
		    query.setInteger(1, 2);
	     
	     std =query.executeUpdate();
	     flag=true;
		 }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
			System.out.println("object got deleted");
		}
		else {
			transaction.rollback();
			System.out.println("object not got deleted");
		}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
}

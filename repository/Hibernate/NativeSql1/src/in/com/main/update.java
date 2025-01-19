package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.com.model.Student2;
import in.com.util.Util;

public class update {

	@SuppressWarnings("unchecked")
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
		 NativeQuery<Student2> query = session.createSQLQuery("UPDATE Student2 set sname=:name,saddress=:address WHERE sid=:id");
	     query.setParameter("name", "Bajju");
	     query.setParameter("id", 5);
	     query.setParameter("address", "BLR");
	     
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
			System.out.println("object got updated");
		}
		else {
			transaction.rollback();
			System.out.println("object not got updated");
		}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
}

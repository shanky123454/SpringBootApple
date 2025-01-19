package in.com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.com.model.Student2;
import in.com.util.Util;

public class select {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Integer std = null;
		Student2 student=null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
		Criteria criteria = session.createCriteria(Student2.class);
	    List<Student2> list = criteria.list();
	     flag=true;
	     list.forEach(System.out::println);
		 }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			//transaction.commit();
			System.out.println("object got selected");
		}
		else {
			//transaction.rollback();
			System.out.println("object not got selected");
		}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}
}

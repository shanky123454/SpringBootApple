package in.com.main;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.com.model.Student2;
import in.com.util.Util;

public class selectapp2 {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
//		Integer std = null;
//		Student student=null;
//		Transaction transaction =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
		 NativeQuery<Student2> query = session.createSQLQuery("select * from Student where sid>=:id1 and sid<=:id2");
		query.setParameter("id1", 1);
		query.setParameter("id2", 2);
		query.addEntity(Student2.class);
		 List<Student2> list =query.list();
		 for (Student2 std : list) {
			System.out.println(std);
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

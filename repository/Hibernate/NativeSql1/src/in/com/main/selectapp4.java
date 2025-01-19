package in.com.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.com.util.Util;

public class selectapp4 {

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
		 NativeQuery<Object[]> query = session.createSQLQuery("select * from Student2 where sid>=:id1 and sid<=:id2");
		query.setParameter("id1", 1);
		query.setParameter("id2", 2);
	
		 List<Object[]> list =query.list();
		
//		 list.forEach(row->{
//			   for (Object objects : row) {
//				System.out.println(objects);
//			}
//				System.out.println(); 
//		 }
//		  
//				 );
		 for (Object[] objects : list) {
			 for (Object obj : objects) {
				 System.out.println(obj);
			}
			System.out.println();
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

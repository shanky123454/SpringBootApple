package in.com.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import in.com.model.Student2;
import in.com.util.Util;

public class select4 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session =null;
		
		// Git hub ke sath mt khelo khatara hai smjha
		
	
	try {
		session= Util.getSession();
		if(session!=null)
		{
		 Criteria criteria = session.createCriteria(Student2.class);
		 
		 Criterion c1 = Restrictions.ge("sage",25);
		 Criterion c2 = Restrictions.le("sage",40);
		 Criterion c3 = Restrictions.between("sid", 3, 5);
		 Criterion c4 = Restrictions.in("sname", "Bajju","Maruti");
		 Criterion c5 = Restrictions.or(Restrictions.and(c1,c2),c3);
		 
		 criteria.add(c5);
		 
	    List<Student2> list = criteria.list();
	    
//	    list.forEach(row->{
//	                         for (Student2 student2 : list) {
//								System.out.println(student2);
//							}
//	                         System.out.println();
//	                       
//	                     }
//	    		);
//		 }	
	  
	     for (Student2 student2 : list) {
			System.out.println(student2);
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

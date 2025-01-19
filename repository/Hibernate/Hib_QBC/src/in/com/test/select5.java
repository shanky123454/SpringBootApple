package in.com.test;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import in.com.model.Student2;
import in.com.util.Util;

public class select5 {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		Session session =null;
	
	try {
		session= Util.getSession();
		if(session!=null)
		{
		 Criteria criteria = session.createCriteria(Student2.class);
		 
		 Criterion c5= Restrictions.eq("sage", "23");
	     Criterion c6= Restrictions.eq("sname", "shanky");

		 
		 criteria.add(c5);
		 criteria.add(c6);
		 
		 ProjectionList list1 = Projections.projectionList();
		 list1.add(Projections.property("sage"));
		 list1.add(Projections.property("sname"));
		 
		 criteria.setProjection(list1);
		 
   List<Student2> list = criteria.list();
    
//    list.forEach(row->{
//                         for (Object student2 : row) {
//							System.out.println(student2);
//						                             }
//                         System.out.println();
//                     }
//    		    );
//	   }		
 
   
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


package in.com.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;

import in.com.model.Student2;
import in.com.util.Util;

public class select2 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Session session =null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
	        CriteriaBuilder cb = session.getCriteriaBuilder();
		
	        CriteriaQuery<Student2> cu = cb.createQuery(Student2.class);
	
		    Root<Student2> r = cu.from(Student2.class);
		  
		    
		   CriteriaQuery<Student2> cq = cu.multiselect(r.get("sname"),r.get("sage"),r.get("sid"));

		  
		       Query q = session.createQuery(cq);

              List<Object[]> list = q.getResultList();
     
//          list.forEach(tuple->{
//                         
//						System.out.printf("name: %s , age: %d%n, id =%d%n",
//						tuple.get(0, String.class), tuple.get(1,Integer.class), tuple.get(2, Integer.class));
//
//                     }
//    		);
          
          list.forEach(row->{
            for (Object student2 : row) {
				System.out.println(student2);
			         }

                 }
                     );
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

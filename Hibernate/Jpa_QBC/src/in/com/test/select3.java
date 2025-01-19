package in.com.test;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import in.com.model.Student2;
import in.com.util.Util;

public class select3 {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Session session =null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
	        CriteriaBuilder cb = session.getCriteriaBuilder();
		
	       // In JPA Criteria API, Tuple provides another way to select multiple values.
	       // Tuple contains ordered query results which can be access via index
	        
	        CriteriaQuery<Tuple> cu = cb.createTupleQuery();
	
		    Root<Student2> r = cu.from(Student2.class);
		  
		   CriteriaQuery<Tuple> cq = cu.multiselect(r.get("sname"),r.get("sage"),r.get("sid"));

		  
		       Query q = session.createQuery(cq);

              List<Tuple> list = q.getResultList();
     
          list.forEach(tupleed->{
                         
						System.out.printf("name: %s , age: %d, id =%d%n",
								tupleed.get(0, String.class), tupleed.get(1,Integer.class), tupleed.get(2, Integer.class));

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

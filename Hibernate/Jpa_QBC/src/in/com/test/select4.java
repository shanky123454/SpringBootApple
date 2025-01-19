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

public class select4 {

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
		  
		
		  
		    CriteriaQuery<Student2> cq = cu.select(r.get("sname"));

		  
		       Query q = session.createQuery(cq);

              List<String> list = q.getResultList();
     
              list.forEach(System.out:: println);
          
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

package in.com.test;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.com.model.Cricketer;
import in.com.util.Util;


public class selectusingJPACriteriaApi {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				
		          CriteriaBuilder cb =  session.getCriteriaBuilder();
		          
		          CriteriaQuery<Cricketer> cq = cb.createQuery(Cricketer.class);
		          
		          Root<Cricketer> root =  cq.from(Cricketer.class);
		           
		          CriteriaQuery<Cricketer> query = cq.select(root);
		        
		          Query<Cricketer> q = session.createQuery(query);
		          
//		          q.setFirstResult(0);
//		          q.setMaxResults(1);		       
		          List<Cricketer> list = q.getResultList();
		      
		          list.forEach(System.out::println);
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{

			Util.closeSession(session);
			Util.closeSessionFactory();
		    }
		}


}

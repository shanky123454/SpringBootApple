package in.com.test;


import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.com.model.CardPayment;
import in.com.model.Payment;
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
		          
		          CriteriaQuery<CardPayment> cq = cb.createQuery(CardPayment.class);
		          
		          Root<CardPayment> root =  cq.from(CardPayment.class);
		           
		          CriteriaQuery<CardPayment> query = cq.select(root);
		        
		          Query<CardPayment> q = session.createQuery(query);
		          
//		          q.setFirstResult(0);
//		          q.setMaxResults(1);		       
		          List<CardPayment> list = q.getResultList();
		      
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

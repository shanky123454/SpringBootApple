package in.com.test;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.com.model.CardPayment;
import in.com.model.Payment;
import in.com.util.Util;


public class selectusinghql {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				
		Query<CardPayment>  query = session.createQuery("FROM in.com.model.CardPayment");
		
//		query.setFirstResult(0);
//		query.setMaxResults(1);

		 
		List<CardPayment> list = query.getResultList();
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

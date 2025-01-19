package in.com.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import in.com.model.Cricketer;
import in.com.util.Util;


public class selectusingHibCriteriaApi {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
			
		        Criteria criteria = session.createCriteria(Cricketer.class);
//		        Criterion resCriterion = Restrictions.eq("Accno",95L);
//		        
//		        criteria.add(resCriterion);
		        
		
		         List<Cricketer> list = criteria.list();
		         
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

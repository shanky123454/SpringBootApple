package in.com.test;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import in.com.model.BankAccount;
import in.com.util.Util;


public class selectusingHibCriteriaApi {

	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				Filter filter  = (Filter) session.enableFilter("filter_bank_account_status");
				filter.setParameter("acctype1", "blocked");
				filter.setParameter("acctype2", "closed");
		        Criteria criteria = session.createCriteria(BankAccount.class);
		        Criterion resCriterion = Restrictions.ge("balance", 2500.f);
		        
		        criteria.add(resCriterion);
		        
		         List<BankAccount> list = criteria.list();
		         
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

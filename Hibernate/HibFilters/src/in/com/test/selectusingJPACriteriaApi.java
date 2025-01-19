package in.com.test;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.model.BankAccount;
import in.com.util.Util;


public class selectusingJPACriteriaApi {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				Filter filter  = (Filter) session.enableFilter("filter_bank_account_status");
				filter.setParameter("acctype1", "blocked");
				filter.setParameter("acctype2", "closed");
				
		          CriteriaBuilder cb =  session.getCriteriaBuilder();
		          
		          CriteriaQuery<BankAccount> cq = cb.createQuery(BankAccount.class);
		          
		          Root<BankAccount> root =  cq.from(BankAccount.class);
		           
		          CriteriaQuery<BankAccount> query = cq.select(root).where(cb.ge(root.get("balance"), 2300.f));
		        
		          Query<BankAccount> q = session.createQuery(query);
		       
		          List<BankAccount> list = q.getResultList();
		      
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

package in.com.test;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.model.BankAccount1;
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
				filter.setParameter("acctype2", "savings");
				
		          CriteriaBuilder cb =  session.getCriteriaBuilder();
		          
		          CriteriaQuery<BankAccount1> cq = cb.createQuery(BankAccount1.class);
		          
		          Root<BankAccount1> root =  cq.from(BankAccount1.class);
		           
		          CriteriaQuery<BankAccount1> query = cq.select(root).where(cb.equal(root.get("Accno"),95));
		        
		          Query<BankAccount1> q = session.createQuery(query);
		          
//		          q.setFirstResult(0);
//		          q.setMaxResults(1);		       
		          List<BankAccount1> list = q.getResultList();
		      
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

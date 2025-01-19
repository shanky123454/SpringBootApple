package in.com.test;


import java.util.List;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import in.com.model.BankAccount;
import in.com.util.Util;


public class selectusingnativesql {

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
	              NativeQuery<BankAccount>  query = session.createNativeQuery("select * from bankAccount where balance>=:amount");
	              // Filter is not applicable for NativeSQL.
		     query.setParameter("amount", 2500.f);
		      query.addEntity(BankAccount.class);
		      query.setFirstResult(0);
		      query.setMaxResults(2);
		      List<BankAccount> list = query.getResultList();
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

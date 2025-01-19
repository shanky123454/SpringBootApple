package in.com.test;

import java.util.List;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.com.model.CardPayment;
import in.com.model.ChequePayment;
import in.com.model.Payment;
import in.com.util.Util;


public class selectusingnativesql {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
//				Filter filter  = (Filter) session.enableFilter("filter_bank_account_status");
//				filter.setParameter("acctype1", "blocked");
//				filter.setParameter("acctype2", "closed");
	              NativeQuery<CardPayment>  query = session.createNativeQuery("select * from Card_Payment");
	              // Not possible by NativeSQl
	              // Filter is not applicable for NativeSQL.
		    // query.setParameter("amount", 2500.f);
		      query.addEntity(CardPayment.class);
//		      query.setFirstResult(0);
//		      query.setMaxResults(2);
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

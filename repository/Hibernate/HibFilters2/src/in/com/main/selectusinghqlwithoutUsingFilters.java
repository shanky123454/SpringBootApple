package in.com.main;


import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.model.BankAccount;
import in.com.util.Util;


public class selectusinghqlwithoutUsingFilters {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{

		Query<BankAccount>  query = session.createQuery("FROM in.com.model.BankAccount");
		
		// @Where clause is also added implicitly to query for filtering 
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

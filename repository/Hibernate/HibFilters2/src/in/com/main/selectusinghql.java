package in.com.main;


import java.util.List;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import in.com.model.BankAccount;
import in.com.util.Util;


public class selectusinghql {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction =null;
		int list=0;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				transaction= session.beginTransaction();
		Query<BankAccount>  query = session.createQuery("UPDATE in.com.model.BankAccount SET accttype='saving' WHERE accno=:no");
		 query.setParameter("no", 12456);
		 
		// so if we use HQL,NativeSQL,QBC logics then we need to explicity write "update sql 
		// query" for soft deletion.
		 
		list = query.executeUpdate();
		  
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{
				if (list==1) {
					transaction.commit();
				} else {
					transaction.rollback();
				}

			Util.closeSession(session);
			Util.closeSessionFactory();
		    }
		}

}

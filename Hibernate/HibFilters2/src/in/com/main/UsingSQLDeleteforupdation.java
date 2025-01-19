package in.com.main;


import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.BankAccount;
import in.com.util.Util;


public class UsingSQLDeleteforupdation {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction =null;
		boolean flg=false;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				transaction=session.beginTransaction();
//				Filter filter  = (Filter) session.enableFilter("filter_bank_account_status");
//				filter.setParameter("acctype1", "blocked");
//				filter.setParameter("acctype2", "closed");
//		          
				BankAccount ba = new BankAccount();
				ba.setAccno(12456);
				
				session.delete(ba);// @SQLXXXX Annotations Only applicable for single row operations not
				// for bulk operations. Using HQL,NATIVE SQL,Criteria API we perform bulk operations
				// So @SQLXXX not triggered by these operations.
		         flg=true;
		
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{
             if (flg==true) {
				transaction.commit();
			} else {
				transaction.rollback();
			}
			Util.closeSession(session);
			Util.closeSessionFactory();
		    }
		}

}

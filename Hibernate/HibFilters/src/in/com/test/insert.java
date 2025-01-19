package in.com.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.com.model.BankAccount;
import in.com.util.Util;


public class insert {

	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction =null;
		Boolean flag =false;
		Long id =null;
		
		try {
			session=Util.getSession();
			if (session!=null)
			{
				transaction=session.beginTransaction();
				BankAccount bacc = new BankAccount();
				bacc.setAccno(17895);
				bacc.setAccholdername("pucchu");
				bacc.setBalance(34558.66f);
				bacc.setAccttype("blocked");
				bacc.setAddress("hjp");
				
				id =(Long) session.save(bacc);
				flag=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			if(flag==true)
			{
				transaction.commit();
				System.out.println("record inserted successfully");
			}
			else {
				transaction.rollback();
				System.out.println("record not inserted");
			}
			
			Util.closeSession(session);
			Util.closeSessionFactory();
		}
	}

}

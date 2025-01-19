package in.com.test;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Card;
import in.com.model.Cheque;
import in.com.util.HibernateUtil;


public class insert {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Session session =null;
		Transaction transaction =null;
		Boolean flag =false;
		
		
		try {
			session=HibernateUtil.getSession();
			if (session!=null)
			
				transaction=session.beginTransaction();
			
				if(transaction!=null)
				{
				Cheque chq = new Cheque();
				chq.setPayment_id(1);
				chq.setAmount(4500.f);
				chq.setCheque_no(4444456789L);
				chq.setChequeType("self");
				chq.setExpiryDate(LocalDate.of(2023, 06, 24));
				
				
				
				Card ca = new Card();
				ca.setPayment_id(2);
				ca.setAmount(45667.f);
				ca.setCard_no(345678L);
				ca.setCard_type("visa");
				ca.setCvv(456);
				ca.setExpiry_date(LocalDate.of(2026, 12, 23));
				
				
				
				 session.save(chq);
				 session.save(ca);
				
				flag=true;
			}
		}catch(HibernateException e)
		{
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
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
			
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
	}

}

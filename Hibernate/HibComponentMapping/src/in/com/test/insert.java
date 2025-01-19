package in.com.test;

import org.hibernate.Session;

import org.hibernate.Transaction;

import in.com.model.Address;
import in.com.model.BankAccount1;
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
				BankAccount1 bacc = new BankAccount1();
				Address address = new Address();
				address.setCity("BLR");
				address.setState("KARNATAKA");
				address.setZipcode(560066L);
				bacc.setAccno(95);
				bacc.setAccholdername("SHASHANK");
				bacc.setBalance(3458958.66f);
				bacc.setAccttype("savings");
				bacc.setAddress(address);
				
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

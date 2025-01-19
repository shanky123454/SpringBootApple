package in.com.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.StudentDetails;
import in.com.util.Util;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Transaction transaction =null;
		StudentDetails sd=null;
		Integer id = null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
	         sd = new StudentDetails();
	        sd.setSname("RituLika Raj");
	        sd.setSemester(8);
	       // sd.setDob(new Date(1998, 10, 14));
	        sd.setDob(LocalDate.of(1997, 10, 31));
	        sd.setDoj(LocalDateTime.of(2022, 8, 4, 7, 30));
	        sd.setStd_course("dbms");
	       sd.setCid(33);  
		   id=	(Integer)session.save(sd);
		    flag=true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally {
		if(flag==true)
		{
			transaction.commit();
			System.out.println("object got inserted with id:" + id);
			System.out.println(sd);
	     }
		else {
			transaction.rollback();
			System.out.println("object not got inserted with id::" +id);
		    }
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}


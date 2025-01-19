package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Delete2 {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student=null;
		Transaction transaction =null;
		Integer id = 93;
	try {
		session= Util.getSession();
		if(session!=null)
		{
			student= session.get(Student.class, id);
		    transaction= session.beginTransaction();
		}
		
		if(student!=null)
		{
		if(transaction!=null)
		{
			System.out.println(student);
		    session.delete(student);
		    flag=true;
		}
		}
		else {
			System.out.println("record not present for id" +id);
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
			System.out.println("object got deleted");
	     }
		else {
			transaction.rollback();
			System.out.println("object not got deleted");

		}
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}


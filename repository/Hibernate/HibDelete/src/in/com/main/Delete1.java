package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Delete1 {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student=null;
		Transaction transaction =null;
		Integer id = 90;
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
			student = new Student();
			student.setSid(id);// programmer must know which sid to be deleted
		    session.delete(student);
		    flag=true;
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


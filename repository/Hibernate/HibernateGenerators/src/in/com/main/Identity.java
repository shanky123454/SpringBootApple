package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.model.Studentuuu;
import in.com.util.Util;

public class Identity {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Studentuuu student=null;
		Transaction transaction =null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
			student = new Studentuuu();
			student.setSname("ratan tata");
			student.setAge(22);
			student.setSaddress("patna");
			
			session.persist(student);
		    flag=true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
			int id =student.getSid();
			String name =student.getSname();
			System.out.println(id+" " + name);
			System.out.println("object got inserted");
	     }
		else {
			transaction.rollback();
			System.out.println("object not got inserted");
		    }
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}


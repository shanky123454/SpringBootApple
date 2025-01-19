package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.util.Util;

public class Update1 {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student=null;
		Transaction transaction =null;
		//Integer id = 95;
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
		    student = new Student();
		    student.setSid(93);// programmer must know which sid to be updated
		    student.setSname("shashank raj");
		    student.setAge(25);
		    student.setSaddress("BLR");
		    
		    session.update(student);
		    flag=true;
		}
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			System.in.read();
			transaction.commit();
			System.out.println("object got updated");
	     }
		else {
			System.out.println("object not got updated");

		}
	Util.closeSession(session);
	Util.closeSessionFactory();
	}
	}
}


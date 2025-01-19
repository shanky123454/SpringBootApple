package in.com.main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
import in.com.model.StudentDetails;
import in.com.util.Util;

public class InsertApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student=null;
		Transaction transaction =null;
		Student id = null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
			student = new Student();
	        student.setCid(120);
	        student.setSid(95);
			
	        StudentDetails sd = new StudentDetails();
	        sd.setSname("shashank Raj");
	        sd.setSemester(8);
	        sd.setStudent(student);
	        
		id=	(Student)session.save(sd);
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


package in.com.main;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student1;
import in.com.model.StudentDetails2;
import in.com.util.Util;

public class InsertAppVersionApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student1 student=null;
		Transaction transaction =null;
		Student1 id = null;
		
	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction= session.beginTransaction();
		}
		if(transaction!=null)
		{
			student = new Student1();
	        student.setCid(12345);
	        student.setSid(6789);
			
	        StudentDetails2 sd = new StudentDetails2();
	        sd.setSname("Ritu Raj");
	        sd.setSemester(8);
	       // sd.setDob(new Date(1998, 10, 14));
	        sd.setDob(LocalDate.of(1997, 10, 31));
	        sd.setDoj(LocalDateTime.of(2022, 8, 4, 7, 30));
	        sd.setStd_course("dbms");
	        sd.setStudent(student);
	        
		id=	(Student1)session.save(sd);
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


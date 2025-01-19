package in.com.main;

import java.io.File;
import java.io.FileReader;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.com.model.Student;
import in.com.util.Util;

public class Insert {

	public static void main(String[] args) {
		Session session =null;
		boolean flag = false;
		Integer std = null;
		Student student=null;
		Transaction transaction =null;
		char[] imageReader =null ;

	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction = session.beginTransaction();
	    }
		  if(transaction!=null)  
		  {
	     File f = new File("C:\\Users\\ASUS\\Downloads", "hero.txt");
		 FileReader fr = new FileReader(f);
		 imageReader = new char[(int) f.length()];
		 fr.read(imageReader);
	     student = new Student();
		 student.setSname("RITU");
		 student.setAge(28);
		 student.setSaddress("BLR");
		 student.setResume(imageReader);
		 
		std= (Integer) session.save(student);
		   flag =true;
		  }		
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println("object got saved " + std);}
		else {
			transaction.rollback();
			System.out.println("object not got saved" + std);
		}
	}
	
	Util.closeSession(session);
	Util.closeSessionFactory();
	
	}
}

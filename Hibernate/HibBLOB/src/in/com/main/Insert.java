package in.com.main;

import java.io.FileInputStream;

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
		byte[] imageReader =null;

	try {
		session= Util.getSession();
		if(session!=null)
		{
		transaction = session.beginTransaction();
	    }
		  if(transaction!=null)  
		  {
		 FileInputStream fis = new FileInputStream("C:\\Users\\ASUS\\Downloads\\dora.png");
		 imageReader = new byte[fis.available()];
		 fis.read(imageReader);
	     student = new Student();
		 student.setSname("RITU");
		 student.setAge(28);
		 student.setSaddress("BLR");
		 student.setPhoto(imageReader);
		 
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

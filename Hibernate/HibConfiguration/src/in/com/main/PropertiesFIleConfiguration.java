package in.com.main;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.model.Student;


public class PropertiesFIleConfiguration {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student = null;
		Integer id =90;
		Transaction transaction =null;

	try {
		Configuration configuration = new Configuration();// if we keep property file name as 
		// Hibernate.properties then we dont have to do next 5 lines of coding 
		// by default HIBERNATE searches for hibernate.properties
		File f = new File("C:\\Users\\ASUS\\git\\Hibernate\\HibConfiguration\\src","Hib.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		
		configuration.setProperties(p);
		
		configuration.addAnnotatedClass(Student.class);
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		 session = factory.openSession();

		if(session!=null)
		{
			 student = session.get(Student.class,id);
			transaction = session.beginTransaction();
		}
	 if(student!=null) {
		 if(transaction!=null)
		 {
			   System.out.println(student); 
				 flag =true;
		 }
		}
	 else {
		 System.out.println("student record is not present with id" + id);
	 }
			
	}catch(Exception e)
	{
		e.printStackTrace();
	}finally {
		if(flag==true)
		{
			transaction.commit();
		System.out.println(student);}
		else {
			transaction.rollback();
			System.out.println("data not present with given id" + id);
		}
	}
	

	
	}
}

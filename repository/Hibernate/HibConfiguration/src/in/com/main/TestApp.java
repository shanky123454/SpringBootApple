package in.com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import in.com.model.Student;


public class TestApp {

	public static void main(String[] args) throws Exception {
		Session session =null;
		boolean flag = false;
		Student student = null;
		Integer id =90;
		Transaction transaction =null;

	try {
		Configuration configuration = new Configuration();
		
		
		configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		configuration.setProperty("hibernate.connection.url", "jdbc:mysql:///student");
		configuration.setProperty("hibernate.connection.username", "root");
		configuration.setProperty("hibernate.connection.password", "Shanky@123");

		configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		configuration.setProperty("hibernate.show_sql", "true");
		configuration.setProperty("hibernate.format_sql", "true");
		configuration.setProperty("hibernate.hbm2ddl.auto", "update");
		
		configuration.configure();
		
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

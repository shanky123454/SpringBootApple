package in.com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import in.com.model.Student1;

public class MainClass {

	public static void main(String[] args) {
		
		// 1. Inform JVM to activate HIBERNATE
		Configuration config = new Configuration();
		config.configure(); // to configure ****.xml file 
		
		// Creating a SessionFactory object to hold many other objects required HIBERNATE
		SessionFactory sessionFactory =config.buildSessionFactory();
		
		// Using SessionFactory object, get only one Session object to perform our 
		// persistence operation
		Session session = sessionFactory.openSession();// connection object,ORM-dialects,L1-Cache,TXTManagement
		
		Transaction transaction = session.beginTransaction(); // transaction.begin()
		
		// 2. Create PERSITENCE Object
		Student1 s = new Student1();
		s.setAge(25);
		s.setSaddress("BLR");
		s.setSid(93);
		s.setSname("SAMEER");
		
		// 3. Perform PERISTENCE operation using Entity/Model/POJO object
		session.save(s);
		
		// 4. commit the operation based on the result
		transaction.commit();
		
		session.close();
		sessionFactory.close();
		
	}

}


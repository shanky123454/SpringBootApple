package in.com.util;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.com.model.BankAccount1;

public class Util {

	public static SessionFactory sessionFactory =null;
	public static Session session =null;
	static {
		
		sessionFactory = new Configuration().configure().addAnnotatedClass(BankAccount1.class).buildSessionFactory();
	}
	
	
	public static Session getSession()
	{
		session = sessionFactory.openSession();
		
		return session;
	}
	
	public static void closeSession(Session session)
	{
		session.close();
	}
	
	public static void closeSessionFactory()
	{
		sessionFactory.close();
	}

}

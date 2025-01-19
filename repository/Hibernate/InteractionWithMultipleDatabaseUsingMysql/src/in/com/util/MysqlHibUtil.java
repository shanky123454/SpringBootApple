package in.com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.com.model.Student;
import in.com.model.StudentDetails;

public class MysqlHibUtil {

	public static SessionFactory sessionFactory =null;
	public static Session session =null;
	static {
		
		sessionFactory = new Configuration().configure("in/com/xml/Mysqlhibernate.cfg.xml")
				.addAnnotatedClass(StudentDetails.class).buildSessionFactory();
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

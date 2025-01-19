package in.com.util;

import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import in.com.model.StudentDetails2;

public class Util {

	public static SessionFactory sessionFactory =null;
	public static Session session =null;
	static {
		
		sessionFactory = new Configuration().configure()
				.addAnnotatedClass(StudentDetails2.class).buildSessionFactory();
	}
	
	
	public static Session getSession()
	{
		session = sessionFactory.openSession();
		
		return session;
	}
	
	public static void closeSession(Session session)
	{
		session.close();
		session.clear();
		Cache cache = sessionFactory.getCache();

		if (cache != null) {
		    cache.evictAllRegions();// Evict data from all query regions.
		 
		}
	}
	
	public static void closeSessionFactory()
	{
		sessionFactory.close();
	}

}

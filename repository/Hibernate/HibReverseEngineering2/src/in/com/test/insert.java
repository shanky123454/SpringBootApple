package in.com.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student2;
import in.com.util.Util;

public class insert {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;

		try {
			session =Util.getSession();

			if (session != null)
				transaction = session.beginTransaction();

			if (transaction != null) {

				Student2 s
				 = new Student2();
				s.setSid(95);
				s.setSname("Adarsh Raj");
				s.setSage(33);
				s.setSaddress("Patna");
				
				
				session.save(s);
				

				flag = true;
			}

		} catch (HibernateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Object saved to database");
			} else {
				transaction.rollback();
				System.out.println("Object not saved to the database...");
			}

			Util.closeSession(session);
			Util.closeSessionFactory();
		}

	}
}
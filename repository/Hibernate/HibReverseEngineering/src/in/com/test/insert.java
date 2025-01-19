package in.com.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Student;
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

				Student s
				 = new Student();
				//s.setSid(95);
				s.setSname("ritu Raj");
				s.setSage(33);
				s.setSaddress("DEHARADUN");
				s.setCount(10);
				
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
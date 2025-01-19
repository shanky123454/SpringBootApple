package in.com.test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.com.model.Cricketer;
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

				Cricketer c = new Cricketer();
				c.setCid(7);
				c.setName("dhoni");
				c.setAddress("ranchi");
				c.setFriends_name(List.of("Sachin","raina","virat"));
				c.setMobile_phones(Set.of(9988776655L,7788990055L,3344556677L));
				c.setAccount_no(Map.of("HDFC", 12345L, "ICICI", 3456778L, "AXIS", 5678898L));
				
				session.save(c);
				
				

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
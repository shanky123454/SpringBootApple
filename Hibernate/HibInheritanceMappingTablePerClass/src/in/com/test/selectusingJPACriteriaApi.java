package in.com.test;


import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
import in.com.model.Payment;
import in.com.util.Util;


public class selectusingJPACriteriaApi {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Session session =null;
		try {
			session=Util.getSession();
			if (session!=null)
			{
				
		          CriteriaBuilder cb =  session.getCriteriaBuilder();
		          
		          CriteriaQuery<Payment> cq = cb.createQuery(Payment.class);
		          
		          Root<Payment> root =  cq.from(Payment.class);
		           
		          CriteriaQuery<Payment> query = cq.select(root).where(cb.equal(root.get("pid"),1235));
		        
		          Query<Payment> q = session.createQuery(query);
		          
//		          q.setFirstResult(0);
//		          q.setMaxResults(1);		       
		          List<Payment> list = q.getResultList();
		      
		          list.forEach(System.out::println);
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}finally
			{

			Util.closeSession(session);
			Util.closeSessionFactory();
		    }
		}


}

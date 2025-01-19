package in.com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import in.com.bo.CustomerBo;

@Repository
public class CustomerDaoImplClass implements CustomerDaoInterface {
	
	String sqlquery = "insert into customer(cname,caddress,pamt,rate,time,intersetamount)values(?,?,?,?,?,?)";
	
	@Autowired
	public JdbcTemplate jdbcTemplate;   

	
	static {
		System.out.println("CustomerDaoImplClass.enclosing_method()");
	}
	
	public CustomerDaoImplClass()
	{
		System.out.println("CustomerDaoImplClass.CustomerDaoImplClass()");
	}

	@Override
	public int save(CustomerBo bo) {
		int count =0;
		try
		{
		count =jdbcTemplate.update(sqlquery, bo.getCname(),bo.getCaddress(),
					 bo.getPamt(),bo.getRate(),bo.getTime(),bo.getIntersetamount());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return count;
	}

}

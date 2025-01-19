package in.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.com.bo.CustomerBo;

@Repository
public class CustomerDaoImplClass implements CustomerDaoInterface {
	
	String sqlquery = "insert into customer(cname,caddress,pamt,rate,time,intersetamount)values(?,?,?,?,?,?)";
	
	@Autowired
	public DataSource dataSource;   

	
	static {
		System.out.println("CustomerDaoImplClass.enclosing_method()");
	}
	
	public CustomerDaoImplClass(DataSource dataSource)
	{
		this.dataSource=dataSource;
		System.out.println("CustomerDaoImplClass.CustomerDaoImplClass()");
	}

	@Override
	public CustomerBo save(CustomerBo bo) {
		CustomerBo lst = new CustomerBo();
		BeanUtils.copyProperties(bo, lst);
		System.out.println(lst);
		int count =0;
		try(Connection con = dataSource.getConnection();
				
		PreparedStatement pstmt = con.prepareStatement(sqlquery))
		{
			pstmt.setString(1, bo.getCname());
			pstmt.setString(2, bo.getCaddress());
			pstmt.setFloat(3, bo.getPamt());
			pstmt.setFloat(4, bo.getRate());
			pstmt.setFloat(5, bo.getTime());
		    pstmt.setFloat(6, bo.getIntersetamount());
			
			 count =pstmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return lst;
	}

}

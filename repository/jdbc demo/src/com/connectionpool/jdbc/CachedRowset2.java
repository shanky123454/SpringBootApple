package com.connectionpool.jdbc;
import java.sql.*;


import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


//select using cachedrowset
public class CachedRowset2 {

	public static void main(String[] args) {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet res= null;
		
		
		try {
			//con=DriverManager.getConnection("jdbc:mysql:///movie","root","Shanky@123");
			RowSetFactory rsf = RowSetProvider.newFactory();
			CachedRowSet crs = rsf.createCachedRowSet();// because cachedrowset works in disconnected mode
			
			
			// setting the connection
			crs.setUrl("jdbc:mysql:///movie");
			crs.setUsername("root");
			crs.setPassword("Shanky@123");
			
			crs.setCommand("select * from movies");
			crs.execute();
			
//			if(con!=null)
//			{
//				pstmt=con.prepareStatement("select * from movies");
//			}
//			
//			if(pstmt!=null)
//			{
//				res =pstmt.executeQuery();
//			}
			//crs.populate(res);
			//con.close();//if we close the connection then output is not obtained.
			
//			if(res!=null)
//			{
//				System.out.println("SID \t SNAME \t SANAME \t SBALANCE");
//				while(res.next())
//				{
//					System.out.println(res.getInt(1)+ "\t" + res.getString(2)+"\t" + res.getString(3) +"\t" + res.getInt(4));
//				}
//			}
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
			
			if(crs!=null)
			{
				System.out.println("SID \t SNAME \t SANAME \t SBALANCE");
				while(crs.next())
				{
					System.out.println(crs.getInt(1)+ "\t" + crs.getString(2)+"\t" + crs.getString(3) +"\t" + crs.getInt(4));
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		

	}

}

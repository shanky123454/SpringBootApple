package com.jdbc.demo;
import com.jdbc.in.Util;

import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Jdbctransaction2 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		Connection con = null;
		ResultSet res= null;
		Statement stm = null;
		
				try {
					con =Util.getconnection();
					
					if(con!=null)
					{
						stm =con.createStatement();
						System.out.println("transaction begins");
						
						
						con.setAutoCommit(false);
						
						stm.executeUpdate("insert into politics (name,party_name) values ('modi','bjp')");
						stm.executeUpdate("insert into politics (name,party_name) values ('rahul','congress')");
						
						Savepoint sp = con.setSavepoint();
						stm.executeUpdate("insert into politics (name,party_name) values ('chacha','aap')");
						
						System.out.println("uuufhh entered wrogn inputs");
						con.rollback(sp);
						
						
						System.out.println("Operations are rolled back to savepoint....");
						
						con.releaseSavepoint(sp);
						
						con.commit();
						
						System.out.println("transaction completed........");
			
					}
			
				} catch (SQLException | IOException e) {
			
					e.printStackTrace();
				}finally
				{
					try {
						Util.cleanup(con, stm, res);
						
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
				}
	
	}

}

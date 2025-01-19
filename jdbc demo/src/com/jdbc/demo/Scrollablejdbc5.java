package com.jdbc.demo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.in.Util;

public class Scrollablejdbc5 {

	public static void main(String[] args) {
		Scanner sc  = null;
		Connection con = null;
		ResultSet res= null;
		Statement stm = null;
		ResultSet r = null;
		
				try {
					con = Util.getconnection();
					
					if(con!=null)
					{
						stm = con.createStatement(res.TYPE_SCROLL_INSENSITIVE,res.CONCUR_UPDATABLE);
					}
					
					if(stm!=null)
					{
						String sqlquery="select * from employees";
						res=stm.executeQuery(sqlquery);
					}
					
					if(res!=null)
					{
						System.out.println("before updation");
						System.out.println("EID \t ENAME \t EAGE");
						while(res.next())
						{
							System.out.println(res.getInt("id")+"\t" + res.getString("name")+"\t"+ res.getInt("age"));
						}
					}
					System.in.read();
					
					
					res.beforeFirst();
					while(res.next())
					{
						int age =res.getInt(3);
						if(age<80)
						{
							int newage = age+10;
							res.updateInt("age", newage);
							res.updateRow();
						}
					}
						System.out.println("after updation");
						System.out.println("EID \t ENAME \t EAGE");
						res.beforeFirst();
						while(res.next())
						{					
							System.out.println(res.getInt("id")+"\t" + res.getString("name")+"\t"+ res.getInt("age"));
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

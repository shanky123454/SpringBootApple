package com.jdbc.demo;

import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.in.Util;

public class Scrollablejdbc {

	public static void main(String[] args) {
		Scanner sc  = null;
		Connection con = null;
		ResultSet res= null;
		Statement stm = null;
		ResultSet r = null;
		
				try {
					
					String sqlquery ="select * from movies";
					con = Util.getconnection();
					if(con!=null)
					{
						//stm = con.createStatement(res.TYPE_SCROLL_INSENSITIVE,res.CONCUR_READ_ONLY);
						stm = con.createStatement(res.TYPE_SCROLL_INSENSITIVE,res.CONCUR_UPDATABLE);
					}
					if(stm!=null)
					{
						
						res=stm.executeQuery(sqlquery);
					}
					if(res!=null)
					{
						System.out.println("ID\t NAME\t ACTOR_NAME\t BALANCE");
						while(res.next())
						{
						int id =res.getInt("id");
						String name =res.getString("name");
						String actor_name=	res.getString("actor_name");
						int balance =res.getInt("balance");
						
						System.out.println(id +"\t"+ name +"\t"+ actor_name+"\t" + balance);	
						}
						
						System.out.println();
						
						//res.last();
						System.out.println("ID\t NAME\t ACTOR_NAME\t BALANCE");
						while(res.previous())
						{
						int id =res.getInt("id");
						String name =res.getString("name");
						String actor_name=	res.getString("actor_name");
						int balance =res.getInt("balance");
						
						System.out.println(id +"\t"+ name +"\t"+ actor_name+"\t" + balance);	
						}
					
						
//						absolute() -> it works from the BFR or from ALR. // BFR=> before first row   ALR=> after last row 
//						relative() -> it works w.r.t current position.
						
						
						System.out.println();
						res.first();
						System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3)
						+ "\t" + res.getInt(4));
						
						System.out.println();
						res.last();
						System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3)
						+ "\t" + res.getInt(4));
						
					     System.out.println();
					     res.relative(-2);
					     System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3)
							+ "\t" + res.getInt(4));
					     System.out.println();
					     res.absolute(3);
					     System.out.println(res.getInt(1) + "\t" + res.getString(2) + "\t" + res.getString(3)
							+ "\t" + res.getInt(4));
						
					}
					
				} catch (SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally
				{
					try {
						Util.cleanup(con, stm, res);
						Util.cleanup(null, null, r);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
	
	}

}

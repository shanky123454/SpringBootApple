package com.jdbc.demo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.in.Util;

public class Jdbctransaction {

	public static void main(String[] args) {
		Scanner sc  = null;
		Connection con = null;
		ResultSet res= null;
		Statement stm = null;
		ResultSet r = null;
		
				try {
					
					System.out.println("data before transaction");
					String sqlquery ="select * from movies";
					con = Util.getconnection();
					if(con!=null)
					{
						stm = con.createStatement();
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
						
					}
					
					// TRANSACTION WILL BEGIN
					
					System.out.println("\n  transaction begins");
					
					
					con.setAutoCommit(false);
					
					//PREPARE THE QUERIES AS A SINGLE UNIT
					stm.executeUpdate("update movies  set balance=150000 where actor_name='maheshbabu'");
					stm.executeUpdate("update movies  set balance=120000 where actor_name='govinda'");	
					
					Savepoint sp = con.setSavepoint();
					
					stm.executeUpdate("update  movies set balance = balance-1000 where actor_name='maheshbabu'");
					stm.executeUpdate("update  movies set balance = balance+1000 where actor_name='govinda'");
					
					//Savepoint sp = con.setSavepoint();
					System.out.println("you want to transfer the funds[yes/no]");
					sc=new Scanner(System.in);
					String input = sc.next();
					
					if(input.equalsIgnoreCase("yes"))
					{
						con.commit();
					}
					else
					{
						con.releaseSavepoint(sp);
						con.rollback(sp);
						con.commit();
					}
					
					
					System.out.println(" data after transaction");
					r = stm.executeQuery("select * from movies");
					if(r!=null)
					{
						System.out.println("ID\t NAME\t ACTOR_NAME\t BALANCE");
						while(r.next())
						{
						int id =r.getInt("id");
						String name =r.getString("name");
						String actor_name=	r.getString("actor_name");
						int balance =r.getInt("balance");
						
						System.out.println(id +"\t"+ name +"\t"+ actor_name+"\t" + balance);	
						}
						
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

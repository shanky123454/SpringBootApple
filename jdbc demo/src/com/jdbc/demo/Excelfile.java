package com.jdbc.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Excelfile {

		// workbook.<sheetname> represents the table name
	

		public static void main(String[] args) {
			
			Connection connection =null;
			ResultSet res= null;
			PreparedStatement pstmt =null;
			
			 String EXCEL_FILE = "select * from Data.student";
			
			//jdbc:Excel:///location where the file is present
			String url = "jdbc:Excel:///C:\\Users\\ASUS\\Downloads";
			
			try {
				connection = DriverManager.getConnection(url);
				if(connection!=null)
				{
			
				 pstmt = connection.prepareStatement(EXCEL_FILE);
				}
				
				if(pstmt!=null)
				{
					ResultSet resultSet = pstmt.executeQuery();
					while (resultSet.next()) {
						System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));
					
					}
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
     }

}



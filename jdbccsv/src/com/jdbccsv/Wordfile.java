package com.jdbccsv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Wordfile {

	public static void main(String[] args) {
	 
		
		// csv file represents the table name
		final String CSV_SELECT = "select * from Data.csv";

		
			
			//jdbc:Excel:///location where the file is present
			String url = "jdbc:Text:///C:\\Users\\ASUS\\OneDrive\\Documents";
			
			try (Connection connection = DriverManager.getConnection(url)) {
				try (PreparedStatement pstmt = connection.prepareStatement(CSV_SELECT)) {
					try (ResultSet resultSet = pstmt.executeQuery()) {
						while (resultSet.next()) {
							System.out.println(
									resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3));
						}
					}
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

}


	}



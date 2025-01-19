package com.jdbccsv;
import java.sql.*;
import java.util.*;

public class TextInsert {
        
	 // csv filename represents the table name
	static String CSV_INSERT = "insert into  data.csv values(?,?,?)";

		public static void main(String[] args) {
			String name = null;
			int id = 0;
			int age=0;
			Scanner scanner = null;

			try {
				scanner = new Scanner(System.in);
				if (scanner != null) {
					System.out.print("Enter the name :: ");
					name = scanner.next();
					System.out.print("Enter the age:: ");
					age = scanner.nextInt();
					System.out.print("Enter the id:: ");
					id = scanner.nextInt();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (scanner != null) {
					scanner.close();
				}
			}

			// jdbc:Excel:///location where the file is present
			String url = "jdbc:Text:///C:\\Users\\ASUS\\OneDrive\\Documents";
			try (Connection connection = DriverManager.getConnection(url)) {
				try (PreparedStatement pstmt = connection.prepareStatement(CSV_INSERT)) {
					pstmt.setInt(1, id);
					pstmt.setString(2, name);
					pstmt.setInt(3, age);

					int count = pstmt.executeUpdate();

					if (count == 0) {
						System.out.println("record not inserted...");
					} else {
						System.out.println("record inserted...");
					}
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
}
}

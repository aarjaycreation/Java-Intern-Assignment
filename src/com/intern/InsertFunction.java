package com.intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertFunction {
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/STUDENT_DB";
		String username = "root";
		String password = "";
		
		String student_no = "101";
		String student_name = "Rahul Jangir";
	    String dob = "1998-01-22";
	    String doj = "2022-01-08";
		try {
            //Create the connection object
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		 
		    String sql = "INSERT INTO student (student_no, student_name, dob, doj) VALUES (?, ?, ?, ?)";
            //Execute the query
		    PreparedStatement statement = conn.prepareStatement(sql);
		    statement.setString(1, student_no);
		    statement.setString(2, student_name);
		    statement.setString(3, dob);
		    statement.setString(4, doj);
		     
		    int rowsInserted = statement.executeUpdate();
		    if (rowsInserted > 0) {
		        System.out.println("A new student was inserted successfully!");
		    }
		    //close connection
		        conn.close();
		    
		} catch (SQLException ex) {
		    ex.printStackTrace();
		}
	  }
}

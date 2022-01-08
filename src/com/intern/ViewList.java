package com.intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ViewList {
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/STUDENT_DB";
		String username = "root";
		String password = "";
		
		try {
//			Create the connection object
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    String sql = "SELECT * FROM student";
		    
		    Statement statement = conn.createStatement();
		    
//		    Execute the query
		    ResultSet result = statement.executeQuery(sql);
		     
		    int count = 0;
		     
		    while (result.next()){
		        String student_no = result.getString(1);
		        String student_name = result.getString(2);
		        String dob = result.getString(3);
		        String doj = result.getString(4);
		     
		        String output = "Student #%d: %s - %s - %s - %s";
		        System.out.println(String.format(output, ++count, student_no, student_name, dob, doj));
		    }
		   
		    //close connection
	        conn.close();
	    
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
  }
}

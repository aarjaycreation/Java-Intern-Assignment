package com.intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateFunction {
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/STUDENT_DB";
		String username = "root";
		String password = "";
		
		String student_no = "102";
		String student_name = "Ronak Jangir";
	    String dob = "1994-01-17";
	    String doj = "2021-08-08";
		try {
//			Create the connection object
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    String sql = "UPDATE student SET student_no=?, student_name=?, dob=? WHERE doj=?";
		    
//		    Execute the query
		    PreparedStatement statement = conn.prepareStatement(sql);
		    statement.setString(1, student_no);
		    statement.setString(2, student_name);
		    statement.setString(3, dob);
		    statement.setString(4, doj);
		     
		    int rowsUpdated = statement.executeUpdate();
		    if (rowsUpdated > 0) {
		        System.out.println("An existing Student was updated successfully!");
		    }
		    
//		    close connection
	        conn.close();
	    
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
  }
}

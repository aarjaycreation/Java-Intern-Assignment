package com.intern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteFunction {
	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/STUDENT_DB";
		String username = "root";
		String password = "";
		
		try {
//			Create the connection object
		    Connection conn = DriverManager.getConnection(dbURL, username, password);
		    String sql = "DELETE FROM student WHERE student_no=?";
//		    Execute the query

		    PreparedStatement statement = conn.prepareStatement(sql);
		    statement.setString(1, "101");
		    int rowsDeleted = statement.executeUpdate();
		    if (rowsDeleted > 0) {
		        System.out.println("A student was deleted successfully!");
		    }
		    
		    //close connection
	        conn.close();
	    
	} catch (SQLException ex) {
	    ex.printStackTrace();
	}
  }
}		



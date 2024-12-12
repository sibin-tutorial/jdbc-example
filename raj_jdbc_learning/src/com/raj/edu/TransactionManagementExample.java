package com.raj.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TransactionManagementExample {

	
	 private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	    private static final String USER = "postgres";
	    private static final String PASSWORD = "root";
	    
	    
	    public static void main(String []args) {
	    	
	    	try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD)){
	    		
	    		conn.setAutoCommit(false);
	    		
	    		
	    		try(Statement stmt = conn.createStatement()){
	    			
	    			String insertFirstRow = "INSERT INTO users (name,email) values ('Tom','tom@gmail.com')";
	    			stmt.executeUpdate(insertFirstRow);
	    			System.out.println("First row inserted");
	    			
	    				String insertSecondRow = "INSERT INTO user (name,email) values(NULL,NULL)";
	    				stmt.executeUpdate(insertSecondRow);
	    				System.out.println("Second row inserted");
	    		}catch(Exception e) {
	    			conn.rollback();
	    			System.out.println("Rolled back");
	    		}
	    		conn.commit();
	    		
	    	}catch(Exception e) {
	    		
	    		System.out.println(e);
	    	}
	    }
}

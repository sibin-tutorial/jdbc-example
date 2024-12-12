package com.raj.edu;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class CallableStatementExample {
	
	private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private final static String USERNAME = "postgres";
	private final static String PASSWORD = "root";
	
	public static void main(String []args) {
		
		try(Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD)){
			
			 // Calling the add_numbers function
            String sql = "{ ? = call add_numbers(?, ?) }"; // The SQL for calling a function
            
            try(CallableStatement cl = conn.prepareCall(sql)){
            	//Register the return type
            	cl.registerOutParameter(1, Types.INTEGER);
            	
            	
            	//Set the parameters
            	cl.setInt(2, 6); //Paramater a
            	cl.setInt(3, 4); // Parameter b
            	
            	cl.execute();
            	
            	System.out.println("Successfully executed Callable statement");
            	
            	int sum = cl.getInt(1);
            	
            	System.out.println(sum);
            	
            }
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}

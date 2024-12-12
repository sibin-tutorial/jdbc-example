package com.raj.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Here we are trying to connect the postgresqlSQL database
public class PostgreSQLConnectionTest {

	private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private final static String USERNAME = "postgres";
	private final static String PASSWORD = "root";
	
	
	
	public static void main(String []args) {
		
		//try catch with resource
		/*
		 * In Java, the try-with-resources statement was introduced in Java 7 to simplify the management of resources that need to be closed after use, such as files, database connections, sockets, etc. The resources are automatically closed at the end of the try block, ensuring that they are properly closed even if an exception occurs.
		 */
		
		try (Connection conn=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);){
		  System.out.println("Successfully connected to database");
		}catch(Exception e) {
			System.out.println(e);
		}
		
		}
		}
	


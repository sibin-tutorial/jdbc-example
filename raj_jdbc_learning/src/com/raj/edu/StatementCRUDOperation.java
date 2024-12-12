package com.raj.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Here we are doing CRUD operation using Statement Interface
public class StatementCRUDOperation {
	
	private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private final static String USERNAME = "postgres";
	private final static String PASSWORD = "root";
	
	
	public static void main(String []args) {
		
	try(Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			Statement stmt = conn.createStatement();){
		System.out.println("Successfully connected to database");
	
	    //CRUD Operations using statement interface
	    //Inserting data using Statement
		String insertQuery = "INSERT INTO users(name,email) values('aswathy','aswathy45@gmail.com')";
		stmt.executeUpdate(insertQuery);
		System.out.println("Data successfully inserted");
		
		
		//Retrieve data
		String selectUsers = "select * from users;";
		ResultSet resultSet = stmt.executeQuery(selectUsers);
		while(resultSet.next()) {
			Integer id = resultSet.getInt("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			
			System.out.println("ID: "+id+" Name: "+name+ "Email: "+email);
		}
		
		
		//Update data
		String updateQuery = "UPDATE users set name='Insha' where name='aswathy'";
		stmt.executeUpdate(updateQuery);
		System.out.println("Successfully updated");
		
		
		//Delete operation
		String deleteQuery = "DELETE from users where name = 'Insha'";
		stmt.executeUpdate(deleteQuery);
		System.out.println("User deleted");
		
	}catch(Exception e) {
		System.out.println(e);
	}
		
		
	}
	

}

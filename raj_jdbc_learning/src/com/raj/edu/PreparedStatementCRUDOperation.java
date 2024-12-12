package com.raj.edu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PreparedStatementCRUDOperation {

	private final static String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
	private final static String USERNAME = "postgres";
	private final static String PASSWORD = "root";
	
	
	public static void main(String []args) {
		
		
		try(Connection conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD)){
			System.out.println("Successfully connected to database");
		
			
			//Insert data
			String insertQuery = "INSERT into users (name,email) values (?,?)";
			try(PreparedStatement ps = conn.prepareStatement(insertQuery);){
				ps.setString(1, "tom");
				ps.setString(2, "tom@gmail.com");
				ps.executeUpdate();
				System.out.println("Record successfully inserted");
			}
			
			
			//Retrieve data
			String retrieveData = "select * from users";
			try(PreparedStatement ps = conn.prepareStatement(retrieveData)){
				ResultSet resultSet = ps.executeQuery();
				
				while(resultSet.next()) {
					Integer id = resultSet.getInt("id");
					String name = resultSet.getString("name");
					String email = resultSet.getString("email");
					
					System.out.println("Id= "+id+" "+"Name= "+name+" Email="+email);
					
				}
					
			}
			
			//Update row
			String updateQuery = "UPDATE users set email = ? where name = ?";
			
			try(PreparedStatement ps = conn.prepareStatement(updateQuery)){
				ps.setString(1, "jerry@gmail.com");
				ps.setString(2, "tom");
				ps.executeUpdate();
				System.out.println("Data update successsfully");
			}
			
			//Delete operation
			String deleteQuery = "DELETE FROM users where name = ?";
			
			try(PreparedStatement ps = conn.prepareStatement(deleteQuery)){
				
				ps.setString(1, "tom");
				ps.executeUpdate();
				System.out.println("Record removed successfully");
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}

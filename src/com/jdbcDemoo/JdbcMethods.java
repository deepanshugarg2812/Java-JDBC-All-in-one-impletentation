package com.jdbcDemoo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;

public class JdbcMethods {
	//This is the instance variable for the connection object
	Connection con = null;
	
	//Get the connection object
	public void createConnnection() {
		try {
			//This loads the driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdb","root","DeepGar2812#*");
			
			System.out.println("Check if connection is open -: " + con.isValid(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("There has been some problem in creating the connection");
			e.printStackTrace();
		}
	}
	
	//Perform the insert operation
	public boolean insertMember(GYMMember mem) {
		if(this.con==null) {
			//Step 1 is to get the connection
			this.createConnnection();
		}
		
		if(con!=null) {
			try {
				String query = DatabaseQuery.insertQuery;
				
				//Create a prepared statement
				PreparedStatement ps = con.prepareStatement(query);
				
				//insert the parameters in the query
				ps.setString(1, mem.getName());
				ps.setDouble(2, mem.getHeightInCm());
				ps.setDouble(3, mem.getWeightInKG());
				ps.setDate(4, mem.getJoiningDate());
				ps.setDate(5, mem.getEndingDate());
				ps.setInt(6, mem.getFeesPaid());
				
				//Execute the query to save in the database
				int recordsInserted = ps.executeUpdate();
				
				if(recordsInserted>0) {
					System.out.println("Record are inserted");
					return true;
				}
				else {
					System.out.println("Record is not inserted");
					return false;
				}
			}catch(Exception e) {
				System.out.println("Technical error occured");
				return false;
			}
		}
	
		return false;
	}
	
	public void searchMemberByName(String name) {
		if(this.con==null) {
			//Step 1 is to get the connection
			this.createConnnection();
		}
		
		if(con!=null) {
			try {
				String query = DatabaseQuery.searchMemberByNameQuery;
				
				//Create a prepared statement
				PreparedStatement ps = con.prepareStatement(query);
				
				//insert the parameters in the query
				ps.setString(1, name);
				
				//Execute the query to retrive data from the database
				ResultSet rs = ps.executeQuery();
				
				java.sql.ResultSetMetaData rms = rs.getMetaData();
				
				//Index names
				System.out.println(rms.getColumnName(1) + "  " + rms.getColumnName(2) + "  " + rms.getColumnName(3) + "   " + rms.getColumnName(4) + "   " + rms.getColumnName(5) + "  " + rms.getColumnName(6) + "  " + rms.getColumnName(7));
				while(rs.next()) {
					//Print the current row
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getDate(3) + "   " + rs.getDate(4) + "   " + rs.getFloat(5) + "  " + rs.getFloat(6) + "  " + rs.getInt(7));
				}
				
			}catch(Exception e) {
				System.out.println("Technical error occured");
			}
		}
	}
	
	public void deleteById(int id) {
		if(this.con==null) {
			//Step 1 is to get the connection
			this.createConnnection();
		}
		
		if(con!=null) {
			try {
				String query = DatabaseQuery.deleteByMemberIdQuery;
				
				//Create a prepared statement
				PreparedStatement ps = con.prepareStatement(query);
				
				//insert the parameters in the query
				ps.setInt(1, id);
				
				//Execute the query to retrive data from the database
				int res = ps.executeUpdate();
				
				if(res>0) {
					System.out.println("Record deleted successfully");
				}
				else {
					System.out.println("Record not deleted successfully");
				}
				
			}catch(Exception e) {
				System.out.println("Technical error occured");
			}
		}
	}

}

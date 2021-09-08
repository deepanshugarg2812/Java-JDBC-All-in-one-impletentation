package com.jdbcDemoo;

public class DatabaseQuery {
	static String insertQuery = "INSERT INTO members(name,height,weight,joiningDate,endingDate,fees) values (?,?,?,?,?,?)";
	static String searchMemberByNameQuery = "SELECT * FROM members WHERE name = ?";
	static String deleteByMemberIdQuery = "DELETE FROM members WHERE id = ?";
}

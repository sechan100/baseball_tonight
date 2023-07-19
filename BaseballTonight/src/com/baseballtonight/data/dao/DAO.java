package com.baseballtonight.data.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	
	Connection con;
	Statement state;
	
	public DAO() {
		String url = "jdbc:mysql://localhost:3306/?user=root";
		try {
			con = DriverManager.getConnection(url, "root", "dlqhfka");
			state = con.createStatement();
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public ResultSet select(String SQL) {
		ResultSet rs;
		try {
			rs = state.executeQuery(SQL);
			return rs;
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println("DAO에서 예외발생");
		}
		return null;
	}

	public void update(String SQL) {
		try {
			state.executeUpdate(SQL);
		} catch(SQLException e) {
			System.out.println(e);
		}
	}

}

package com.test.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnectionTest {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/instructor-database?useSSL=false&serverTimezone=UTC";
		String username = "Student-Database";
		String pass = "koushikRuidas";
		try {
			Connection con = DriverManager.getConnection(url, username, pass);
			con.close();
			System.out.println("Connection was successful");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

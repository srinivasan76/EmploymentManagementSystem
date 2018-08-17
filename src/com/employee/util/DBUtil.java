package com.employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



public class DBUtil { 

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection =  DriverManager.getConnection("jdbc:mysql://localhost/employee", "root", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

	public static void close(Connection connection, Statement statement, ResultSet resultSet) {

		try {
			if (connection != null) {
				connection.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}

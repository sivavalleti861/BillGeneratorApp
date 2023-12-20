package Databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	private Connection connection;
	private String url;
	private String username;
	private String password;

	public Database(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}

	public void connect() throws SQLException {
		connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connected to the database!");
	}

	public void disconnect() throws SQLException {
		if (connection != null && !connection.isClosed()) {
			connection.close();
			System.out.println("Disconnected from the database!");
		}
	}

	public ResultSet executeQuery(String sqlQuery) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		return statement.executeQuery();
	}

	public int executeUpdate(String sqlQuery) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		return statement.executeUpdate();
	}

}

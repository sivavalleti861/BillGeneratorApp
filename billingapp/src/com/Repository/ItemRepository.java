package com.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ItemRepository {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/hotel_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	public void showMenu() {
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("SELECT * FROM items");
				ResultSet rs = stmt.executeQuery()) {
			System.out.println("Menu:");
			System.out.println("Item ID\tItem Name\tPrice");
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				System.out.println(id + "\t" + name + "\t$" + price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public double getItemPrice(int itemId) {
		double price = 0;

		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				PreparedStatement stmt = conn.prepareStatement("SELECT price FROM items WHERE id = ?")) {
			stmt.setInt(1, itemId);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				price = rs.getDouble("price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return price;
	}
}

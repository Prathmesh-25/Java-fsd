package com.practice.dao;
import com.practice.model.AdminUser;
import com.practice.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminProfileDAO {
 // Method to fetch admin user by username
	public AdminUser getAdminUserByUsername(String username) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		AdminUser adminUser = null;
		try {
			connection = DBUtil.getConnection();
			String query = "SELECT * FROM admin_users WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				adminUser = new AdminUser();
 
				adminUser.setUsername(resultSet.getString("username"));
 
				adminUser.setPassword(resultSet.getString("password"));
 
				adminUser.setFullName(resultSet.getString("full_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception appropriately
		} finally {
			// Close the resources
			closeResources(resultSet, preparedStatement, connection);
		}
		return adminUser;
	}
	// Method to update admin user profile
	public boolean updateAdminProfile(AdminUser adminUser) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean success = false;
		try {
			connection = DBUtil.getConnection();
			String query = "UPDATE admin_users SET full_name = ?, /* add other fields */ WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, adminUser.getFullName());
			int rowsAffected = preparedStatement.executeUpdate();
			success = (rowsAffected > 0);
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception appropriately
		} finally {
			// Close the resources
			closeResources(null, preparedStatement, connection);
		}
		return success;
	}
	// Method to change admin user password
	public boolean changeAdminPassword(String username, String newPassword) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean success = false;
		try {
			connection = DBUtil.getConnection();
			String query = "UPDATE admin_users SET password = ? WHERE username = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, username);
			int rowsAffected = preparedStatement.executeUpdate();
			success = (rowsAffected > 0);
		} catch (SQLException e) {
			e.printStackTrace(); // Handle the exception appropriately
		} finally {
			// Close the resources (PreparedStatement, Connection)
			closeResources(null, preparedStatement, connection);
		}
		return success;
	}
	// Utility method to close resources
	private void closeResources(ResultSet resultSet, 
			PreparedStatement preparedStatement, Connection connection) {
		try {
			if (resultSet != null) resultSet.close();
			if (preparedStatement != null) 
				preparedStatement.close();
			if (connection != null) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
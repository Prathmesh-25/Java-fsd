package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.practice.model.User;
import com.practice.util.DBUtil;
public class UserDAO {
	public User authenticateUser(String username, String password) {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement("SELECT * FROM user WHERE username = ? AND password = ?")) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			try (ResultSet resultSet = 
					preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					User user = new User();
 
					user.setUserId(resultSet.getInt("user_id"));
 
					user.setUsername(resultSet.getString("username"));
 
					user.setPassword(resultSet.getString("password"));
 
					user.setFullName(resultSet.getString("full_name"));
					return user;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean registerUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = DBUtil.getConnection();
			String sql = "INSERT INTO user (username, password, full_name) VALUES (?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getFullName());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return false;
	}
	public String getFullNameByUsername(String username) {
		String fullName = null;
		try (Connection connection = DBUtil.getConnection()) {
			String sql = "SELECT full_name FROM user WHERE username = ?";
			try (PreparedStatement preparedStatement = 
					connection.prepareStatement(sql)) {
				preparedStatement.setString(1, username);
				try (ResultSet resultSet = 
						preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						fullName = resultSet.getString("full_name");
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
		}
		return fullName;
	}
}


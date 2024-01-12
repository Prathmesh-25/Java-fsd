package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.practice.model.Admin;
import com.practice.util.DBUtil;
public class AdminDAO {
	public Admin authenticateAdmin(String username, String password) {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?")) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			try (ResultSet resultSet = 
					preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					Admin admin = new Admin();
 
					admin.setAdminId(resultSet.getInt("admin_id"));
 
					admin.setUsername(resultSet.getString("username"));
 
					admin.setPassword(resultSet.getString("password"));
 
					admin.setFullName(resultSet.getString("full_name"));
					return admin;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

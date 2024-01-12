package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.practice.util.DBUtil;
public class AdminDashboardDAO {
	// Method to get total quiz count
	public int getTotalQuizCount() {
		String query = "SELECT COUNT(*) AS totalQuiz FROM quiz";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(query);
				ResultSet resultSet = 
						preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				int totalQuiz = resultSet.getInt("totalQuiz");
				System.out.println("Total Quiz Count: " + totalQuiz);
				return totalQuiz;
			}
		} catch (SQLException e) {
			System.out.println("Error fetching total quiz count: " + e.getMessage());
		}
		return 0; // Return 0 if an error occurs
	}
	// Method to get total question count
	public int getTotalQuestionCount() {
		String query = "SELECT COUNT(*) AS totalQuestions FROM question";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(query);
				ResultSet resultSet = 
						preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				int totalQuestions = 
						resultSet.getInt("totalQuestions");
				System.out.println("Total Questions Count: " + totalQuestions);
				return totalQuestions;
			}
		} catch (SQLException e) {
			System.out.println("Error fetching total question count: " + e.getMessage());
		}
		return 0; 
	}
	// Method to get total user count
	public int getTotalUserCount() {
		String query = "SELECT COUNT(*) AS totalUsers FROM user";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(query);
				ResultSet resultSet = 
						preparedStatement.executeQuery()) {
			if (resultSet.next()) {
				int totalUsers = 
						resultSet.getInt("totalUsers");
				System.out.println("Total Users Count: " + totalUsers);
				return totalUsers;
			}
		} catch (SQLException e) {
			System.out.println("Error fetching total user count: " + e.getMessage());
		}
		return 0;
	}
}


package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.practice.model.Option;
import com.practice.util.DBUtil;
public class OptionDAO {
	private Connection getConnection() throws SQLException {
		return DBUtil.getConnection();
	}
	// Method to get options for a question
	public List<Option> getOptionsForQuestion(int questionId) {
		List<Option> options = new ArrayList<>();
		String query = "SELECT * FROM options WHERE question_id = ?";
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, questionId);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Option option = new Option();
	 
					option.setOptionId(resultSet.getInt("option_id"));
	 
					option.setOptionText(resultSet.getString("option_text"));
	 
					option.setCorrect(resultSet.getBoolean("is_correct"));
					options.add(option);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle the exception appropriately
		}
		return options;
	 }
	 	// Method to add an option
	 	public boolean addOption(Option option) {
	 		String query = "INSERT INTO options (question_id, option_text, is_correct) VALUES (?, ?, ?)";
	 		try (Connection connection = getConnection();
	 				PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	 			preparedStatement.setInt(1, option.getQuestionId());
	 			preparedStatement.setString(2, option.getOptionText());
	 			preparedStatement.setBoolean(3, option.isCorrect());
	 			int rowsAffected = preparedStatement.executeUpdate();
	 			return rowsAffected > 0;
	 		} catch (SQLException e) {
	 			e.printStackTrace();
	 			return false;
	 	}
	 }
}


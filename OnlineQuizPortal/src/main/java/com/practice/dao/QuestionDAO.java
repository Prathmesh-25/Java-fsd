package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.practice.model.Question;
import com.practice.util.DBUtil;
public class QuestionDAO {
	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM question")) {
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Question question = new Question();
 
					question.setQuestionId(resultSet.getInt("question_id"));
 
					question.setQuestionText(resultSet.getString("question_text"));
 
					question.setOption1(resultSet.getString("option1"));
 
					question.setOption2(resultSet.getString("option2"));
 
					question.setOption3(resultSet.getString("option3"));
 
					question.setOption4(resultSet.getString("option4"));
 
					question.setCorrectOption(resultSet.getInt("correct_option"));
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return questions;
	}
	// Other Question-related DAO methods can be added here
	private static final String INSERT_QUESTION_QUERY = "INSERT INTO question (question_text, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
 
	public boolean addQuestion(Question question) {
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUESTION_QUERY)) {
			preparedStatement.setString(1, 
					question.getQuestionText());
			preparedStatement.setString(2, 
					question.getOption1());
			preparedStatement.setString(3, 
					question.getOption2());
			preparedStatement.setString(4, 
					question.getOption3());
			preparedStatement.setString(5, 
					question.getOption4());
			preparedStatement.setInt(6, 
					question.getCorrectOption());
 
			System.out.println("Final SQL Query: " + preparedStatement.toString());
			int rowsAffected = preparedStatement.executeUpdate();
			return rowsAffected > 0;
		} catch (SQLException e) {
			e.printStackTrace(); 
			return false;
		}
	}
}

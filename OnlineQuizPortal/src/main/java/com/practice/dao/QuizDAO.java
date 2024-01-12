package com.practice.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.practice.model.Option;
import com.practice.model.Question;
import com.practice.model.Quiz;
import com.practice.model.QuizParticipation;
import com.practice.util.DBUtil;
public class QuizDAO {
	public List<Quiz> getAllQuizzes() {
		List<Quiz> quizzes = new ArrayList<>();
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM quiz");
				ResultSet resultSet = preparedStatement.executeQuery()) {
			while (resultSet.next()) {
				Quiz quiz = new Quiz();
				quiz.setQuizId(resultSet.getInt("quiz_id"));
 
				quiz.setQuizName(resultSet.getString("quiz_name"));
				quizzes.add(quiz);
			}
		} catch (SQLException e) {
			e.printStackTrace(); 
			//for debugging
			//System.out.println("SQL Query: SELECT * FROM quiz");
		}
		return quizzes;
	}
	// Other Quiz-related DAO methods can be added here
	public int createQuiz(String quizName) throws SQLException {
		String insertQuizQuery = "INSERT INTO quiz (quiz_name) VALUES (?)";
		int generatedQuizId = 0;
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(insertQuizQuery, 
								PreparedStatement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, quizName);
			int rowsAffected = preparedStatement.executeUpdate();
			if (rowsAffected > 0) {
				// Retrieve the generated quiz ID
				var generatedKeys = preparedStatement.getGeneratedKeys();
				if (generatedKeys.next()) {
					generatedQuizId = generatedKeys.getInt(1);
				}
			}
		}
		return generatedQuizId;
	}
	// Method to add a question to a quiz
	public void addQuestionToQuiz(int quizId, int questionId) throws SQLException {
		String insertQuestionQuery = "INSERT INTO quiz_question (quiz_id, question_id) VALUES (?, ?)";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(insertQuestionQuery)) {
			preparedStatement.setInt(1, quizId);
			preparedStatement.setInt(2, questionId);
			preparedStatement.executeUpdate();
		}
	}
 
	public Quiz getQuizById(int quizId) {
		Quiz quiz = null;
		String query = "SELECT * FROM quiz WHERE quiz_id = ?";
		try (Connection connection = DBUtil.getConnection();
	PreparedStatement preparedStatement = 
			connection.prepareStatement(query)) {
			preparedStatement.setInt(1, quizId);
			try (ResultSet resultSet = 
					preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					quiz = new Quiz();
 
					quiz.setQuizId(resultSet.getInt("quiz_id"));
 
					quiz.setQuizName(resultSet.getString("quiz_name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
 
		}
		return quiz;
	}
	public List<Question> getQuestionsForQuiz(int quizId) {
		List<Question> questions = new ArrayList<>();
		String query = "SELECT q.* FROM question q JOIN quiz_question qq ON q.question_id = qq.question_id WHERE qq.quiz_id = ?;";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(query)) {
			preparedStatement.setInt(1, quizId);
			try (ResultSet resultSet = 
					preparedStatement.executeQuery()) {
				while (resultSet.next()) {
					Question question = new Question();
 
					question.setQuestionId(resultSet.getInt("question_id"));
 
					question.setQuestionText(resultSet.getString("question_text"));
 
					OptionDAO optionDAO = new OptionDAO();
					List<Option> options = 
							optionDAO.getOptionsForQuestion(question.getQuestionId());
					question.setOptions(options);
					questions.add(question);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return questions;
	}
 
	public List<Option> getOptionsForQuiz(int quizId) {
		List<Option> options = new ArrayList<>();
		String query = "SELECT o.* FROM options o " +
					   "JOIN quiz_question qq ON o.question_id = qq.question_id " +
					   "WHERE qq.quiz_id = ?";
		try (Connection connection = DBUtil.getConnection();
				PreparedStatement preparedStatement = 
						connection.prepareStatement(query)) {
			preparedStatement.setInt(1, quizId);
			try (ResultSet resultSet = 
					preparedStatement.executeQuery()) {
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
		}
		return options;
	}
 
	 public List<QuizParticipation> getQuizLeaderboard(int quizId) {
		 List<QuizParticipation> leaderboard = new ArrayList<>();
		 String query = "SELECT qp.user_id, u.username, qp.score " +
				 		"FROM quiz_participation qp " +
				 		"JOIN user u ON qp.user_id = u.id " +
				 		"WHERE qp.quiz_id = ? " +
				 		"ORDER BY qp.score DESC";
		 try (Connection connection = DBUtil.getConnection();
				 PreparedStatement preparedStatement = 
						 connection.prepareStatement(query)) {
			 preparedStatement.setInt(1, quizId);
			 try (ResultSet resultSet = 
					 preparedStatement.executeQuery()) {
				 while (resultSet.next()) {
					 QuizParticipation participation = new QuizParticipation();
 
					 participation.setUserId(resultSet.getInt("user_id"));
 
					 participation.setScore(resultSet.getInt("score"));
					 leaderboard.add(participation);
				 }
			 }
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return leaderboard;
	 }
 
	 public boolean addQuizParticipation(QuizParticipation participation) {
		 String query = "INSERT INTO quiz_participation (user_id, quiz_id, score) VALUES (?, ?, ?)";
		 try (Connection connection = DBUtil.getConnection();
				 PreparedStatement preparedStatement = 
						 connection.prepareStatement(query)) {
			 preparedStatement.setInt(1, 
					 participation.getUserId());
			 preparedStatement.setInt(2, 
					 participation.getQuizId());
			 preparedStatement.setInt(3, 
					 participation.getScore());
			 int rowsAffected = preparedStatement.executeUpdate();
			 return rowsAffected > 0;
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return false;
	 }
}


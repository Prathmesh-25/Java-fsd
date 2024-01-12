package com.practice.model;
import java.util.List;
public class Quiz {
	private int quizId;
	private String quizName;
	private List<Question> questions;
	// Constructor
	public Quiz() {
	}
 
	// Getters and setters
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getQuizName() {
		return quizName;
	}	
	public void setQuizName(String quizName) {
		this.quizName = quizName;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
 
}

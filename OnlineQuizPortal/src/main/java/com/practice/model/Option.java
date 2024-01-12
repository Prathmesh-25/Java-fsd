package com.practice.model;
public class Option {
	private int optionId;
	private int questionId;
	private String optionText;
	private boolean isCorrect;
	// Getters and setters
	public int getOptionId() {
		return optionId;
	}
	public void setOptionId(int optionId) {
		this.optionId = optionId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getOptionText() {
		return optionText;
	}
	public void setOptionText(String optionText) {
		this.optionText = optionText;
	}
	public boolean isCorrect() {
		return isCorrect;
	}
	public void setCorrect(boolean correct) {
		isCorrect = correct;
	}
}
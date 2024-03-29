package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity @Table(name="userfeedback")
public class UserFeedback {
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", feedback1=" + feedback1 + "]";
	}

	@Id @GeneratedValue
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String feedback1;
	
	public UserFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserFeedback(String firstname, String lastname, String email ,String feedback1) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email= email;
		this.feedback1 = feedback1;
	}
	
	
}
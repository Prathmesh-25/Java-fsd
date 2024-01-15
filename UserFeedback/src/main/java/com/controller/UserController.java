package com.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserFeedback;
import com.service.FeedbackService;

@RestController
public class UserController {

	@Autowired
	private FeedbackService service;

	@PostMapping("/userfeedback")
	public String userRegister(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname, @RequestParam("email") String email , @RequestParam("feedback1") String feedback1) {
	UserFeedback f = new UserFeedback(firstname, lastname, email,feedback1);
	boolean data= service.addFeedback(f);
	if(data) {
		return "Feedback added succesfully!";
	}
	else {
		return "Unable to add the feedback";
	}
		
	}
}
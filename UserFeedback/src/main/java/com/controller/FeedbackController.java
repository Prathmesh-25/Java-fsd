package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.service.FeedbackService;


@Controller
public class FeedbackController {
	
	@Autowired
	private FeedbackService appService;
	
	@GetMapping("/userfeedback")
	public String feedback() {
		return "userFeedbackForm";
	}
}
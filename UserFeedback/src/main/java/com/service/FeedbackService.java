package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dao.UserRepo;
import com.entity.UserFeedback;



@Service
public class FeedbackService {

	@Autowired
	private UserRepo myRepo;
	
	public boolean addFeedback( UserFeedback feedback) {
		myRepo.save(feedback);
		return true;
	}
}

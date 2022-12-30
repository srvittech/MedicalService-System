package com.medicalservice.feedback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicalservice.feedback.model.Feedback;
import com.medicalservice.feedback.service.FeedbackServiceImp;

@RestController
public class FeedbackController {
	@Autowired
	FeedbackServiceImp feedbackServiceImp;
	
	@PostMapping("/addFeedback")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		return feedbackServiceImp.addFeedback(feedback);
	}
	
	@GetMapping("/findFeedbackById/{feedbackId}")
	public Feedback findFeedbackById(@PathVariable int feedbackId) {
		return feedbackServiceImp.findFeedbackById(feedbackId);
	}
	
	@PutMapping("/updateFeedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		feedback.setDescription(feedback.getDescription());
		return feedbackServiceImp.updateFeedback(feedback);
	}

	

}

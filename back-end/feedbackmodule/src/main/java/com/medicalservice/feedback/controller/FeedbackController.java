package com.medicalservice.feedback.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);
	@Autowired
	FeedbackServiceImp feedbackServiceImp;
	
	@GetMapping("/getFeedbacks")
	public List<Feedback> getFeedbacks() {
		LOGGER.info("Entering Method getAllFeedbacks in FeedbackController");
		return feedbackServiceImp.getFeedbacks();
	}
	
	@PostMapping("/addFeedback")
	public Feedback addFeedback(@RequestBody Feedback feedback) {
		LOGGER.info("Entering Method addFeedback in FeedbackController");
		return feedbackServiceImp.addFeedback(feedback);
	}
	
	@GetMapping("/findFeedbackById/{feedbackId}")
	public Feedback findFeedbackById(@PathVariable int feedbackId) {
		LOGGER.info("Entering Method findFeedbackById in FeedbackController");
		return feedbackServiceImp.findFeedbackById(feedbackId);
	}
	
	@PutMapping("/updateFeedback")
	public Feedback updateFeedback(@RequestBody Feedback feedback) {
		LOGGER.info("Entering Method updateFeedback in FeedbackController");
		return feedbackServiceImp.updateFeedback(feedback);
	}

	

}

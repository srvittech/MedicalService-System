package com.medicalservice.feedback.service;

import java.util.List;

import com.medicalservice.feedback.model.Feedback;

public interface FeedbackService {
	 public List<Feedback> getFeedbacks();
	
	public Feedback addFeedback(Feedback feedback);
	
	public Feedback findFeedbackById(int patientId);
	
	public Feedback updateFeedback(Feedback feedback);

}

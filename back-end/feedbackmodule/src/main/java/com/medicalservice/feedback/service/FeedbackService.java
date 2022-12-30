package com.medicalservice.feedback.service;

import com.medicalservice.feedback.model.Feedback;

public interface FeedbackService {
	
	public Feedback addFeedback(Feedback feedback);
	
	public Feedback findFeedbackById(int patientId);
	
	public Feedback updateFeedback(Feedback feedback);

}

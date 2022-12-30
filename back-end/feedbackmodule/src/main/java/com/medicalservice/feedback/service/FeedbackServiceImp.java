package com.medicalservice.feedback.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.feedback.model.Feedback;
import com.medicalservice.feedback.repository.FeedbackRepository;

@Service
public class FeedbackServiceImp implements FeedbackService {
	
	@Autowired
	FeedbackRepository feedbackRepo;
    
	@Override
	public Feedback addFeedback(Feedback feedback) {
		return feedbackRepo.save(feedback);
		}
	
	
	@Override
	public Feedback findFeedbackById(int patientId) {
		return feedbackRepo.findById(patientId).orElse(null);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		feedback.setDescription(feedback.getDescription());
		return feedbackRepo.save(feedback);
	}

	
}

package com.medicalservice.feedback.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.feedback.model.Feedback;
import com.medicalservice.feedback.repository.FeedbackRepository;

@Service
public class FeedbackServiceImp implements FeedbackService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackServiceImp.class);
	
	@Autowired
	FeedbackRepository feedbackRepo;
    
	@Override
	public List<Feedback> getFeedbacks() {
		LOGGER.info("Getting All Feedbacks From FeedbackService.....");
		return feedbackRepo.findAll();
	}
	
	@Override
	public Feedback addFeedback(Feedback feedback) {
		LOGGER.info("Adding Feedbacks From FeedbackService.....");
		return feedbackRepo.save(feedback);
		}
	
	
	@Override
	public Feedback findFeedbackById(int patientId) {
		LOGGER.info("Getting All Transactions By Feedback Id From FeedbackService.....");
		return feedbackRepo.findById(patientId).orElse(null);
	}

	@Override
	public Feedback updateFeedback(Feedback feedback) {
		Feedback feedbackToUpdate = feedbackRepo.findById(feedback.getFeedbackId()).orElse(null);
		 if(feedback.getPatientName()!=null) {
			 LOGGER.info("Updating Patient Name From FeedbackService.....");
			 feedbackToUpdate.setPatientName(feedback.getPatientName()); 
		 }
		 if(feedback.getDescription()!=null) {
			 LOGGER.info("Updating Description From FeedbackService.....");
			 feedbackToUpdate.setDescription(feedback.getDescription()); 
		 }
		 if(feedback.getSolution()!=null) {
			 LOGGER.info("Updating Solution From FeedbackService.....");
			 feedbackToUpdate.setSolution(feedback.getSolution()); 
		 }
		return feedbackRepo.save(feedbackToUpdate);
	}

	
}

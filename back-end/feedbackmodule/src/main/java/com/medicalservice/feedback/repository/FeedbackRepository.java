package com.medicalservice.feedback.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalservice.feedback.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer>{

}

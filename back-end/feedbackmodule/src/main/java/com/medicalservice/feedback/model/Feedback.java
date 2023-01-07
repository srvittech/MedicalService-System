package com.medicalservice.feedback.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(generator="feedback_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="feedback_seq",sequenceName="feedback_seq",initialValue=5091753,allocationSize=1)
	private int feedbackId;
	private int patientId;
	private String patientName;
	private String description;
	private String solution;
	
	public Feedback() {
		
	}
	public Feedback(int feedbackId, int patientId, String patientName, String description, String solution) {
		super();
		this.feedbackId = feedbackId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.description = description;
		this.solution = solution;
	}
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", patientId=" + patientId + ", patientName=" + patientName
				+ ", description=" + description + ", solution=" + solution + "]";
	}
	
	

}

package com.medicalservice.feedback.model;

public class Feedback {
	private int feedbackId;
	private String patientId;
	private String patientName;
	private String description;
	private String solution;
	public int getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
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

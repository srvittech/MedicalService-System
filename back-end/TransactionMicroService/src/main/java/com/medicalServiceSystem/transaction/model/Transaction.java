package com.medicalServiceSystem.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TreatmentForm")
public class Transaction {
	
	
	@Id
	private Long transactionId;
	private Long patientId;
	private Long doctorId;
	private String disease;
	private String status = "pending";
	private String prescription;
	private String dateOfRequest;
	private String dateOfTreatment;


	public Transaction() {
		super();
	}


	public Transaction(Long transactionId, Long patientId, Long doctorId, String disease, String status,
			String prescription, String dateOfRequest, String dateOfTreatment) {
		super();
		this.transactionId = transactionId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.disease = disease;
		this.status = status;
		this.prescription = prescription;
		this.dateOfRequest = dateOfRequest;
		this.dateOfTreatment = dateOfTreatment;
	}


	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}


	public Long getPatientId() {
		return patientId;
	}


	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}


	public Long getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}


	public String getDisease() {
		return disease;
	}


	public void setDisease(String disease) {
		this.disease = disease;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPrescription() {
		return prescription;
	}


	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}


	public String getDateOfRequest() {
		return dateOfRequest;
	}


	public void setDateOfRequest(String dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}


	public String getDateOfTreatment() {
		return dateOfTreatment;
	}


	public void setDateOfTreatment(String dateOfTreatment) {
		this.dateOfTreatment = dateOfTreatment;
	}


}

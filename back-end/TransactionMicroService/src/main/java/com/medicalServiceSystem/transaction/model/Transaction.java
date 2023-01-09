package com.medicalServiceSystem.transaction.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TreatmentForm")
public class Transaction {
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private Long transactionId;
	private Long patientId;
	private String patientName;
	private int patientAge;
	private String patientAddress;
	private String disease;
	private int patientweight;
	private Long doctorId;
	private String doctorName;
	private String status = "pending";
	private String prescription = "null";
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
	
	public Transaction(Long transactionId, Long patientId, String patientName, int patientAge, String patientAddress,
			String disease, int patientweight, Long doctorId, String doctorName, String status, String prescription,
			String dateOfRequest, String dateOfTreatment) {
		super();
		this.transactionId = transactionId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientAge = patientAge;
		this.patientAddress = patientAddress;
		this.disease = disease;
		this.patientweight = patientweight;
		this.doctorId = doctorId;
		this.doctorName = doctorName;
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
	
	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public int getPatientweight() {
		return patientweight;
	}

	public void setPatientweight(int patientweight) {
		this.patientweight = patientweight;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", disease=" + disease + ", status=" + status + ", prescription=" + prescription + ", dateOfRequest="
				+ dateOfRequest + ", dateOfTreatment=" + dateOfTreatment + "]";
	}

}

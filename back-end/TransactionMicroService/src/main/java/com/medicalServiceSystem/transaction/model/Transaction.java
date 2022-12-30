package com.medicalServiceSystem.transaction.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TreatmentForm")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private Long patientId;
	private Date dateOfRequest;
	private Long doctorId;
	private String disease;
	private String status = "pending";
	private Date dateOfTreatment;
	private String prescription;

	public Transaction() {
		super();
	}

	public Long getPatientId() {
		return patientId;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public Transaction(Long transactionId, Long patientId, Date dateOfRequest, Long doctorId, String disease,
			String status, Date dateOfTreatment, String prescription) {
		super();
		this.transactionId = transactionId;
		this.patientId = patientId;
		this.dateOfRequest = dateOfRequest;
		this.doctorId = doctorId;
		this.disease = disease;
		this.status = status;
		this.dateOfTreatment = dateOfTreatment;
		this.prescription = prescription;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
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

	public Date getDateOfTreatment() {
		return dateOfTreatment;
	}

	public void setDateOfTreatment(Date dateOfTreatment) {
		this.dateOfTreatment = dateOfTreatment;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

}

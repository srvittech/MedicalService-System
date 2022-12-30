package com.medicalServiceSystem.transacation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TreatmentForm")
public class Transacation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transactionId;
	private int patientId;
	private Date dateOfRequest;
	private int doctorId;
	private String disease;
	private String status = "pending";
	private Date dateOfTreatment;
	private String prescription;

	public Transacation() {
		super();
	}

	public Transacation(int transactionId, int patientId, Date dateOfRequest, int doctorId, String disease, String status,
			Date dateOfTreatment, String prescription) {
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

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Date getDateOfRequest() {
		return dateOfRequest;
	}

	public void setDateOfRequest(Date dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
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

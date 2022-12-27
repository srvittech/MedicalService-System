package com.medicalservice.patient.service;

import java.util.List;

import com.medicalservice.patient.model.patient;



public interface patientservice {
	public List<patient> getpatient();
	public void  addpatient(patient patient);
	public patient findpatientById(int id);
	public void deletepatientById(int id);

}

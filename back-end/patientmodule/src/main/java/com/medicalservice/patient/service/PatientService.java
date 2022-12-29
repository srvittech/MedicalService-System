package com.medicalservice.patient.service;

import java.util.List;

import com.medicalservice.patient.model.Patient;

public interface PatientService {
	public List<Patient> getPatient();
	public void  addPatient(Patient patient);
	public Patient findPatientById(Long id);
	public void deletePatientById(Long id);
}

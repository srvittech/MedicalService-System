package com.medicalservicesystem.patient.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.medicalservicesystem.patient.model.Patient;

public interface PatientService {
	public List<Patient> getPatient();

	public Patient addPatient(Patient patient);

	public Patient findPatientById(Long id);
	
	public Patient findPatientByEmail(String email);

	public void deletePatientById(Long id);
	
	public Patient updatePatient(Patient pateint);
}

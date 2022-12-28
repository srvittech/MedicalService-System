package com.medicalservice.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.patient.model.Patient;
import com.medicalservice.patient.repository.PatientRepository;



@Service
public class PatientServiceImp implements PatientService{
	@Autowired
	PatientRepository patientRepository;
	
	@Override
	public List<Patient> getPatient() {
	
		return patientRepository.findAll();
	}

	@Override
	public void addPatient(Patient patient) {

		patientRepository.save(patient);
	}


	@Override
	public Patient findPatientById(Long id) {
	
		return patientRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePatientById(Long id) {
	
		patientRepository.deleteById(id);
		
		
	}
	

}

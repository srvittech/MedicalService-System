package com.medicalservicesystem.patient.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.medicalservicesystem.patient.model.Patient;
import com.medicalservicesystem.patient.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService {
	@Autowired
	PatientRepository patientRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImp.class);

	@Override
	public List<Patient> getPatient() {
		LOGGER.info("Enter into patient Service Implemention and getting the method getpatients");
		return patientRepository.findAll();
	}

	@Override
	public Patient addPatient(Patient patient) {
		LOGGER.info("Enter into patient Service Implemention and getting the method addPatient");
		return patientRepository.save(patient);
	}

	@Override
	public Patient findPatientById(Long id) {
		LOGGER.info("Enter into patient Service Implemention and getting the method findPatientById");
		return patientRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePatientById(Long id) {
		LOGGER.info("Enter into patient Service Implemention and getting the method deletePatientById");
		patientRepository.deleteById(id);

	}

	@Override
	public Patient updatePatient(Patient patient) {
		 Patient patientToUpdate = patientRepository.findById(patient.getId()).orElse(null);
		 if(patient.getPassword()!=null) {
			 patientToUpdate.setPassword(patient.getPassword()); 
		 }
		 if(patient.getAddress()!=null) {
			 patientToUpdate.setAddress(patient.getAddress()); 
		 }
		 if(patient.getDisease()!=null) {
			 patientToUpdate.setDisease(patient.getDisease()); 
		 }
		 if(patient.getAge()!=0) {
			 patientToUpdate.setAge((patient.getAge())); 
		 }
		 return patientRepository.save(patientToUpdate);
		
	}

}

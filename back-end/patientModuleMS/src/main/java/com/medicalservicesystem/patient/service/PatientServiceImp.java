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
		LOGGER.info("Getting All Patients From PatientService.....");
		return patientRepository.findAll();
	}

	@Override
	public Patient addPatient(Patient patient) {
		LOGGER.info("Adding Patient From PatientService.....");
		return patientRepository.save(patient);
	}

	@Override
	public Patient findPatientById(Long id) {
		LOGGER.info("Getting Patient By Patient Id From PatientService.....");
		return patientRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePatientById(Long id) {
		LOGGER.info("Deleting Patient By Patient Id From PatientService.....");
		patientRepository.deleteById(id);

	}

	@Override
	public Patient updatePatient(Patient patient) {
		 Patient patientToUpdate = patientRepository.findById(patient.getId()).orElse(null);
		 if(patient.getPassword()!=null) {
			 LOGGER.info("Updating Patient Password From TransactionService.....");
			 patientToUpdate.setPassword(patient.getPassword()); 
		 }
		 if(patient.getAddress()!=null) {
			 LOGGER.info("Updating Patient Address From TransactionService.....")
			 patientToUpdate.setAddress(patient.getAddress()); 
		 }
		 if(patient.getDisease()!=null) {
			 LOGGER.info("Updating Patient Disease From TransactionService.....")
			 patientToUpdate.setDisease(patient.getDisease()); 
		 }
		 if(patient.getAge()!=0) {
			 LOGGER.info("Updating Patient Age From TransactionService.....")
			 patientToUpdate.setAge((patient.getAge())); 
		 }
		 return patientRepository.save(patientToUpdate);
		
	}

}

package com.medicalservicesystem.patient.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.medicalservicesystem.patient.model.Patient;
import com.medicalservicesystem.patient.service.PatientServiceImp;

@RestController
@CrossOrigin("*")
public class PatientController {
	@Autowired
	PatientServiceImp patientServiceImp;
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientServiceImp.class);
	

	@GetMapping("/getpatient")
	public List<Patient> getpatients() {
		LOGGER.info("Enter into patient Controller and getting the method getpatients");
		return patientServiceImp.getPatient();
	}

	@PostMapping("/addpatient")
	public void addpatient(@RequestBody Patient patient) {
		LOGGER.info("Enter into patient Controller and getting the method addpatient");
		patientServiceImp.addPatient(patient);
	}

	@GetMapping("/findPatientById/{id}")
	public Patient findPatientById(@PathVariable Long id) {
		LOGGER.info("Enter into patient Controller and getting the findPatientById method ");
		return patientServiceImp.findPatientById(id);
	}
	
	@GetMapping("/findPatientByEmail/{email}")
	public Patient findPatientById(@PathVariable String email) {
		LOGGER.info("Enter into patient Controller and getting the findPatientByEmail method ");
		return patientServiceImp.findPatientByEmail(email);
	}

	@DeleteMapping("/deletePatientById/{id}")
	public void deletePatientById(@PathVariable Long id) {
		LOGGER.info("Enter into patient Controller and getting the deletePatientById method ");
		patientServiceImp.deletePatientById(id);
	}
	
	@PutMapping("/updatePatientById/{id}")
	public Patient updatePatient(@RequestBody Patient patient) {
		LOGGER.info("Enter into patient Controller and getting the updatePatientById method");
		return patientServiceImp.updatePatient(patient);
	}
	{LOGGER.info("Inside the patient Controller ");}
}

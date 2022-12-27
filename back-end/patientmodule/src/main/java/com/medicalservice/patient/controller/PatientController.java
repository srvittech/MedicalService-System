package com.medicalservice.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalservice.patient.model.Patient;
import com.medicalservice.patient.service.PatientServiceImp;


public class PatientController {
	@Autowired
	PatientServiceImp patientServiceImp;
	
	@GetMapping("/getpatient")
	public List<Patient> getpatients(){
		return patientServiceImp.getPatient();
	}
	@PostMapping("/addpatient")
	public void addpatient(@RequestBody Patient patient) {
		patientServiceImp.addPatient(patient);
	}

	@GetMapping("/findpatientById")
	public Patient findpatientById(@PathVariable int id) {
		return patientServiceImp.findPatientById(id);
	}
	@DeleteMapping("/deletepatientById")
	public void deletepatientById(@PathVariable int id) {
		patientServiceImp.deletePatientById(id);
	}


}

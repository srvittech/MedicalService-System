package com.medicalservicesystem.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class PatientController {
	@Autowired
	PatientServiceImp patientServiceImp;

	@GetMapping("/getpatient")
	public List<Patient> getpatients() {
		return patientServiceImp.getPatient();
	}

	@PostMapping("/addpatient")
	public void addpatient(@RequestBody Patient patient) {
		patientServiceImp.addPatient(patient);
	}

	@GetMapping("/findpatientById")
	public Patient findpatientById(@PathVariable Long id) {
		return patientServiceImp.findPatientById(id);
	}

	@DeleteMapping("/deletepatientById")
	public void deletepatientById(@PathVariable Long id) {
		patientServiceImp.deletePatientById(id);
	}
	@PutMapping
	public void updatePatient(Patient patient) {
		patientServiceImp.updatePatient(patient);
	}

}

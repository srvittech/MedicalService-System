package com.medicalservice.patient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalservice.patient.model.patient;
import com.medicalservice.patient.service.patientserviceimp;

public class patientcontroller {
	@Autowired
	patientserviceimp patientserviceimp;
	
	@GetMapping("/getpatient")
	public List<patient> getpatients(){
		return patientserviceimp.getpatient();
	}
	@PostMapping("/addpatient")
	public void addpatient(@RequestBody patient patient) {
		patientserviceimp.addpatient(patient);
	}

	@GetMapping("/findpatientById")
	public patient findpatientById(@PathVariable int id) {
		return patientserviceimp.findpatientById(id);
	}
	@DeleteMapping("/deletepatientById")
	public void deletepatientById(@PathVariable int id) {
		patientserviceimp.deletepatientById(id);
	}


}

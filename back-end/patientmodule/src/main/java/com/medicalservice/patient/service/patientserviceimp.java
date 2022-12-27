package com.medicalservice.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.patient.model.patient;
import com.medicalservice.patient.repository.patientrepository;
@Service
public class patientserviceimp implements patientservice{
	@Autowired
	patientrepository patientrepository;
	
	@Override
	public List<patient> getpatient() {
	
		return patientrepository.findAll();
	}

	@Override
	public void addpatient(patient patient) {

		patientrepository.save(patient);
	}


	@Override
	public patient findpatientById(int id) {
	
		return patientrepository.findById(id).orElse(null);
	}

	@Override
	public void deletepatientById(int id) {
	
		patientrepository.deleteById(id);
		
		
	}
	

}

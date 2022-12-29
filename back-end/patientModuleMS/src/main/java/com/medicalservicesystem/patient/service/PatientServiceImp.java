package com.medicalservicesystem.patient.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservicesystem.patient.model.Patient;
import com.medicalservicesystem.patient.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService {
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

		return patientRepository.getById(id);
	}

	@Override
	public void deletePatientById(Long id) {

		patientRepository.deleteById(id);

	}

}

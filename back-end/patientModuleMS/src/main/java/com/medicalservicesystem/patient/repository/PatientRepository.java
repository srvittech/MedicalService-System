package com.medicalservicesystem.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.medicalservicesystem.patient.model.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	public Patient findByEmail(String email);
}

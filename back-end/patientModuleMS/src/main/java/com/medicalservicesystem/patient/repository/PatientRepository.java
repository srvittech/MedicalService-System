package com.medicalservicesystem.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalservicesystem.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}

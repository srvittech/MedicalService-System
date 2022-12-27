package com.medicalservice.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalservice.patient.model.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {

}

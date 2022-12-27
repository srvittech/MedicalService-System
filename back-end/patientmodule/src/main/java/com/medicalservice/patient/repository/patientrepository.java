package com.medicalservice.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalservice.patient.model.patient;

public interface patientrepository extends JpaRepository<patient,Integer> {

}

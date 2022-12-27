package com.medicalservice.doctor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.medicalservice.doctor.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}

package com.medicalservice.doctor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.medicalservice.doctor.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, Long> {

}

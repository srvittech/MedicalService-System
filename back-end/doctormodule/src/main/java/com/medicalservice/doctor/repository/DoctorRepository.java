package com.medicalservice.doctor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.medicalservice.doctor.model.Doctor;

public interface DoctorRepository extends MongoRepository<Doctor, Long> {
	@Query("{specialization : ?0}")
	List<Doctor> findBySpecialization(String specialization);

}

package com.medicalServiceSystem.transaction.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


import com.medicalServiceSystem.transaction.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {
	
	@Query("{status : ?0}")
	List<Transaction> getTransactionBasedOnStatus(String status);
	@Query("{doctorId : ?0}")
	List<Transaction> getTransactionByDoctorId(Long doctorId);
	@Query("{patientId : ?0}")
	List<Transaction> getTransactionByPatientId(Long patientId);
	
}

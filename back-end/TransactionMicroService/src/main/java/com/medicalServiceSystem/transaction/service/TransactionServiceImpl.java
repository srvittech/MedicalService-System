package com.medicalServiceSystem.transaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepo;

	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepo.save(transaction);
	}

	@Override
	public List<Transaction> getAllTransaction() {
		return transactionRepo.findAll();
	}

	@Override
	public List<Transaction> getTransactionBasedOnStatus(String status) {

		return transactionRepo.getTransactionBasedOnStatus(status);
	}

	@Override
	public List<Transaction> getTransactionByDoctorId(Long doctorId) {
		return transactionRepo.getTransactionByDoctorId(doctorId);
	}

	@Override
	public List<Transaction> getTransactionByPatientId(Long patientId) {
		return transactionRepo.getTransactionByPatientId(patientId);
	}

	@Override
	public Transaction getTransactionByTransactionId(Long transactionId) {
		return transactionRepo.findById(transactionId).orElse(null);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		
		Transaction transactionToUpdate = transactionRepo.findById(transaction.getTransactionId()).orElse(null);
		 if(transaction.getDoctorId()!=null) {
			 transactionToUpdate.setDoctorId(transaction.getDoctorId()); 
		 }
		 if(transaction.getPatientId()!=null) {
			 transactionToUpdate.setPatientId(transaction.getPatientId()); 
		 }
		 if(transaction.getDisease()!=null) {
			 transactionToUpdate.setDisease(transaction.getDisease()); 
		 }
		 if(transaction.getStatus()!=null) {
			 transactionToUpdate.setStatus(transaction.getStatus()); 
		 }
		 
		 if(transaction.getDateOfRequest()!=null) {
			 transactionToUpdate.setDateOfRequest(transaction.getDateOfRequest()); 
		 }
		 if(transaction.getDateOfTreatment()!=null) {
			 transactionToUpdate.setDateOfTreatment(transaction.getDateOfTreatment()); 
		 }
		 if(transaction.getPrescription()!=null) {
			 transactionToUpdate.setPrescription(transaction.getPrescription()); 
		 }
		 
		
		 return transactionRepo.save(transactionToUpdate);
	}



}

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
	public Transaction getTransactionBasedOnStatus(String status) {

		return null;
	}

	@Override
	public Transaction getTransactionByDoctorId(Long doctorId) {
		return null;
	}

	@Override
	public Transaction getTransactionByPatientId(Long patientId) {
		return null;
	}

	@Override
	public void updateTransactionStatus(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTreatment(Transaction transaction) {
		// TODO Auto-generated method stub
	}

	@Override
	public Transaction getTransactionByTransactionId(Long transactionId) {
		return transactionRepo.findById(transactionId).orElse(null);
	}

	@Override
	public void updateTransactionByPatient(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTransactionByKiosk(Transaction transaction) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTransactionByDoctor(Transaction transaction) {
		// TODO Auto-generated method stub

	}

}

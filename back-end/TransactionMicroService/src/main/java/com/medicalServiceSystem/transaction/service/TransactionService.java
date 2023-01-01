package com.medicalServiceSystem.transaction.service;

import java.util.List;


import com.medicalServiceSystem.transaction.model.Transaction;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);

	public List<Transaction> getAllTransaction();

	public List<Transaction> getTransactionBasedOnStatus(String status);

	public List<Transaction> getTransactionByDoctorId(Long doctorId);

	public List<Transaction> getTransactionByPatientId(Long patientId);

	public Transaction getTransactionByTransactionId(Long transactionId);

	public Transaction updateTransaction(Transaction transaction);
	

}

package com.medicalServiceSystem.transaction.service;

import java.util.List;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalServiceSystem.transaction.model.Transaction;

public interface TransactionService {

	public Transaction addTransaction(Transaction transaction);

	public List<Transaction> getAllTransaction();

	public Transaction getTransactionBasedOnStatus(String status);

	public Transaction getTransactionByDoctorId(Long doctorId);

	public Transaction getTransactionByPatientId(Long patientId);

	public void updateTransactionStatus(Transaction transaction);

	public void updateTreatment(Transaction transaction);

	public Transaction getTransactionByTransactionId(Long transactionId);

	public void updateTransactionByPatient(@RequestBody Transaction transaction);

	public void updateTransactionByKiosk(@RequestBody Transaction transaction);

	public void updateTransactionByDoctor(@RequestBody Transaction transaction);

}

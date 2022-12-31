package com.medicalServiceSystem.transaction.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicalServiceSystem.transaction.TransactionMicroServiceApplication;
import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.service.TransactionService;

@RestController
public class TransactionController {
	
	static Logger logger = LogManager.getLogger(TransactionMicroServiceApplication.class);
	@Autowired
	TransactionService transactionService;

	@PostMapping("/addTransaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

	@GetMapping("/getAllTransaction")
	public List<Transaction> getAllTransaction() {
		logger.info("controller working ");
		return transactionService.getAllTransaction();
	}

	@GetMapping("/getTransactionBasedOnStatus/{status}")
	public List<Transaction> getTransactionBasedOnStatus(@PathVariable String status) {
		return transactionService.getTransactionBasedOnStatus(status);
	}

	@GetMapping("/getTransactionByDoctorId/{doctorId}")
	public List<Transaction> getTransactionByDoctorId(@PathVariable Long doctorId) {
		return transactionService.getTransactionByDoctorId(doctorId);
	}

	@GetMapping("/getTransactionByPatientId/{patientId}")
	public List<Transaction> getTransactionByPatientId(@PathVariable Long patientId) {
		return transactionService.getTransactionByPatientId(patientId);
	}

	@GetMapping("/getTransactionByTransactionId/{transactionId}")
	public Transaction getTransactionByTransactionId(Long transactionId) {
		return transactionService.getTransactionByTransactionId(transactionId);
	}

	@PutMapping("/updateTransaction")
	public void updateTransaction(@RequestBody Transaction transaction) {
		transactionService.updateTransaction(transaction);
	}



}

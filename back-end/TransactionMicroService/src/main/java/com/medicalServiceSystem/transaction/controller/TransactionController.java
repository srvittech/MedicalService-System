package com.medicalServiceSystem.transaction.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.service.TransactionServiceImpl;

@RestController
public class TransactionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	@Autowired
	TransactionServiceImpl transactionService;
	@PostMapping("/addTransaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		LOGGER.info("Entering Method addTransaction in TransactionController");
		return transactionService.addTransaction(transaction);
	}

	@GetMapping("/getAllTransaction")
	public List<Transaction> getAllTransaction() {
		LOGGER.info("Entering Method getAllTransaction in TransactionController");
		return transactionService.getAllTransaction();
	}

	@GetMapping("/getTransactionBasedOnStatus/{status}")
	public List<Transaction> getTransactionBasedOnStatus(@PathVariable String status) {
		LOGGER.info("Entering Method getTransactionBasedOnStatus in TransactionController");
		return transactionService.getTransactionBasedOnStatus(status);
	}

	@GetMapping("/getTransactionByDoctorId/{doctorId}")
	public List<Transaction> getTransactionByDoctorId(@PathVariable Long doctorId) {
		LOGGER.info("Entering Method getTransactionByDoctorId in TransactionController");
		return transactionService.getTransactionByDoctorId(doctorId);
	}

	@GetMapping("/getTransactionByPatientId/{patientId}")
	public List<Transaction> getTransactionByPatientId(@PathVariable Long patientId) {
		LOGGER.info("Entering Method getTransactionByPatientId in TransactionController");
		return transactionService.getTransactionByPatientId(patientId);
	}

	@GetMapping("/getTransactionByTransactionId/{transactionId}")
	public Transaction getTransactionByTransactionId(Long transactionId) {
		LOGGER.info("Entering Method getTransactionByTransactionId in TransactionController");
		return transactionService.getTransactionByTransactionId(transactionId);
	}

	@PutMapping("/updateTransaction")
	public void updateTransaction(@RequestBody Transaction transaction) {
		LOGGER.info("Entering Method updateTransaction in TransactionController");
		transactionService.updateTransaction(transaction);
	}



}

package com.medicalServiceSystem.transaction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@PostMapping("/addTransaction")
	public Transaction addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

	@GetMapping("/getTransaction")
	public List<Transaction> getAllTransaction() {
		return transactionService.getAllTransaction();
	}

	@GetMapping("/getTransactionBasedOnStatus")
	public Transaction getTransactionBasedOnStatus(@PathVariable String status) {
		return transactionService.getTransactionBasedOnStatus(status);
	}

	@GetMapping("/getTransactionByDoctorId")
	public Transaction getTransactionByDoctorId(@PathVariable Long doctorId) {
		return transactionService.getTransactionByDoctorId(doctorId);
	}

	@GetMapping("/getTransactionByPatientId")
	public Transaction getTransactionByPatientId(@PathVariable Long patientId) {
		return transactionService.getTransactionByPatientId(patientId);
	}

	@GetMapping("/getTransactionByTransactionId")
	public Transaction getTransactionByTransactionId(Long transactionId) {
		return transactionService.getTransactionByTransactionId(transactionId);
	}

	@PutMapping("/updateTransactionStatus")
	public void updateTransactionStatus(@RequestBody Transaction transaction) {
		transactionService.updateTransactionStatus(transaction);
	}

	@PutMapping("/updateTransactionByPatient")
	public void updateTransactionByPatient(@RequestBody Transaction transaction) {
		transactionService.updateTransactionStatus(transaction);
	}

	@PutMapping("/updateTransactionByKiosk")
	public void updateTransactionByKiosk(@RequestBody Transaction transaction) {
		transactionService.updateTransactionStatus(transaction);
	}

	@PutMapping("/updateTransactionByDoctor")
	public void updateTransactionByDoctor(@RequestBody Transaction transaction) {
		transactionService.updateTransactionStatus(transaction);
	}

	@PutMapping("/updateTreatment")
	public void updateTreatment(@RequestBody Transaction transaction) {
		transactionService.updateTreatment(transaction);
	}

}

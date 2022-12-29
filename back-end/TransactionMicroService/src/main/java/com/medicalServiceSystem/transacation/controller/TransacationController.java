package com.medicalServiceSystem.transacation.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicalServiceSystem.transacation.model.Transacation;

@RestController
public class TransacationController {

//	/addRequest   POST
//	/getTransaction  GET
//	/getRequestBasedOnStatus/{status}    GET
//	/getByDoctorId/{doctorId}            GET
//	/getByPatientId/{patientId}          GET
//	/updateStatus/{patientId}/{status}/{disease}    PUT
//	/updateTreatment/{prescription}/{patientId}    PUT
	@PostMapping()
	public void addTransaction(@RequestBody Transacation transacation) {

	}

	@GetMapping
	public Transacation getTransaction() {
		return null;
	}

	@GetMapping
	public Transacation getTransactionBasedOnStatus() {
		return null;
	}

	@GetMapping
	public Transacation getTransactionByDoctorId() {

	}

	@GetMapping
	public Transacation getTransactionByPatientId() {

	}

	@PutMapping
	public void updateTransactionStatus() {

	}

	@PutMapping
	public void updateTreatment() {

	}

}

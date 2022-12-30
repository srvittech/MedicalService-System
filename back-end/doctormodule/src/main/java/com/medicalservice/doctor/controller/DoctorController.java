package com.medicalservice.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.service.DoctorServiceImpl;

@RestController

public class DoctorController {
	@Autowired
	DoctorServiceImpl doctorServiceImpl;

	@GetMapping("/getDoctors")
	public List<Doctor> getDoctors() {
		return doctorServiceImpl.getDoctors();
	}


	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorServiceImpl.addDoctor(doctor);
	}

	@PutMapping("/updateDoctor")

	public Doctor updateDoctorPassword(@RequestBody Doctor doctor) {
		return doctorServiceImpl.updateDoctor(doctor);
	}


	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		return doctorServiceImpl.updateDoctor(doctor);
	}

	@GetMapping("/findDoctorById/{id}")
	public Doctor findDoctorById(@PathVariable Long id) {
		return doctorServiceImpl.findDoctorById(id);
	}
	
	@GetMapping("getSpecialization/{specialization}")
	public List<Doctor> getSpecialization(String specialization){
		return doctorServiceImpl.getSpecialization(specialization);
	}


	@DeleteMapping("/deleteDoctorById/{id}")
	public void deleteDoctorById(@PathVariable Long id) {
		doctorServiceImpl.deleteDoctorById(id);
		
	}

}

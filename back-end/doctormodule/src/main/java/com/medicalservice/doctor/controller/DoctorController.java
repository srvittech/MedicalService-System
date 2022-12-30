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
	
	@GetMapping("/findDoctorById/{id}")
	public Doctor findDoctorById(@PathVariable Long id) {
		return doctorServiceImpl.findDoctorById(id);
	}

	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return doctorServiceImpl.addDoctor(doctor);
	}

	@PutMapping("/updateDoctorPassword")
	public Doctor updateDoctorPassword(@RequestBody Doctor doctor) {
		return doctorServiceImpl.updateDoctorPassword(doctor);
	}

	@PutMapping("/updateDoctorSpecialization")
	public Doctor updateDoctorSpecialization(@RequestBody Doctor doctor) {
		return doctorServiceImpl.updateDoctorSpecialization(doctor);
	}

	@PutMapping("/updateDoctorYearsOfExperience")
	public Doctor updateDoctorYearsOfExperience(@RequestBody Doctor doctor) {
		return doctorServiceImpl.updateDoctorYearsOfExperience(doctor);
	}

	

	@DeleteMapping("/deleteDoctorById/{id}")
	public void deleteDoctorById(@PathVariable Long id) {
		doctorServiceImpl.deleteDoctorById(id);
	}

}

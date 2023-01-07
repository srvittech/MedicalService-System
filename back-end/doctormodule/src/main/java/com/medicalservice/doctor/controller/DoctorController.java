package com.medicalservice.doctor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.service.DoctorServiceImpl;

@RestController
@CrossOrigin("*")
public class DoctorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	@Autowired
	DoctorServiceImpl doctorServiceImpl;

	@GetMapping("/getDoctors")
	public List<Doctor> getDoctors() {
		LOGGER.info("Entering Method getAllDoctors in DoctorController");
		return doctorServiceImpl.getDoctors();
	}


	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		LOGGER.info("Entering Method addDoctor in DoctorController");
		doctor.setId(doctorServiceImpl.generateSequence(Doctor.SEQUENCE_NAME));
		return doctorServiceImpl.addDoctor(doctor);
	}

	@PutMapping("/updateDoctor")
	public Doctor updateDoctor(@RequestBody Doctor doctor) {
		LOGGER.info("Entering Method updateDoctor in DoctorController");
		return doctorServiceImpl.updateDoctor(doctor);
	}

	@GetMapping("/findDoctorById/{id}")
	public Doctor findDoctorById(@PathVariable Long id) {
		LOGGER.info("Entering Method findDoctorById in DoctorController");
		return doctorServiceImpl.findDoctorById(id);
	}
	
	@GetMapping("getSpecialization/{specialization}")
	public List<Doctor> getSpecialization(@PathVariable String specialization){
		LOGGER.info("Entering Method getSpecialization in DoctorController");
		return doctorServiceImpl.findBySpecialization(specialization);
	}


	@DeleteMapping("/deleteDoctorById/{id}")
	public void deleteDoctorById(@PathVariable Long id) {
		LOGGER.info("Entering Method deleteDoctorById in DoctorController");
		doctorServiceImpl.deleteDoctorById(id);
		
	}

}

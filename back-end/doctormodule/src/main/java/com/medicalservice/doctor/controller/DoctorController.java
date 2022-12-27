package com.medicalservice.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.service.DoctorServiceImp;

@RestController
public class DoctorController {
	
	@Autowired
	DoctorServiceImp doctorServiceImp;
	
	@GetMapping("/getDoctors")
	public List<Doctor> getDoctors(){
		return doctorServiceImp.getDoctors();
	}
	@PostMapping("/addDoctor")
	public void addDoctor(@RequestBody Doctor doctor) {
		doctorServiceImp.addDoctor(doctor);
	}
//	@PutMapping("/updateDoctor")
//	public void updateDoctor(@RequestBody Doctor doctor){
//		doctorServiceImp.updateDoctor(doctor);
//	}
	@GetMapping("/findDoctorById")
	public Doctor findDoctorById(@PathVariable int id) {
		return doctorServiceImp.findDoctorById(id);
	}
	@DeleteMapping("/deleteDoctorById")
	public void deleteDoctorById(@PathVariable int id) {
		doctorServiceImp.deleteDoctorById(id);
	}

}

package com.medicalservice.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImp implements DoctorService {
	@Autowired
	DoctorRepository doctorRepo;

	@Override
	public List<Doctor> getDoctors() {

		return doctorRepo.findAll();
	}

	@Override
	public void addDoctor(Doctor doctor) {

		doctorRepo.save(doctor);
	}

//	@Override
//	public void updateDoctor(Doctor doctor) {
//	
//		
//	}

	@Override
	public Doctor findDoctorById(Long id) {
		// TODO Auto-generated method stub
		return doctorRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteDoctorById(Long id) {
		// TODO Auto-generated method stub
		doctorRepo.deleteById(id);
	}

}

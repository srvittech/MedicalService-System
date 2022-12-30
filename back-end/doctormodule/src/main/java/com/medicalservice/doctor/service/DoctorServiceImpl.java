package com.medicalservice.doctor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorRepository doctorRepo;

	@Override
	public List<Doctor> getDoctors() {
		return doctorRepo.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor findDoctorById(Long id) {
		return doctorRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteDoctorById(Long id) {
		doctorRepo.deleteById(id);
	}

	@Override
	public Doctor updateDoctorPassword(Doctor doctor) {
		// Doctor doctorToUpdate = doctorRepo.findById(doctor.getId()).orElse(null);
		// doctorToUpdate.setPassword(doctor.getPassword());
		// return doctorRepo.save(doctorToUpdate);
		doctor.setDoctorName(doctor.getDoctorName());
		doctor.setPassword(doctor.getPassword());
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor updateDoctorSpecialization(Doctor doctor) {
		doctor.setSpecialization(doctor.getSpecialization());
		return doctorRepo.save(doctor);

	}

	@Override
	public Doctor updateDoctorYearsOfExperience(Doctor doctor) {
		Doctor doctorToUpdate = doctorRepo.findById(doctor.getId()).orElse(null);
		doctorToUpdate.setYearsOfExperience(doctor.getYearsOfExperience());
		return doctorRepo.save(doctorToUpdate);

	}

}

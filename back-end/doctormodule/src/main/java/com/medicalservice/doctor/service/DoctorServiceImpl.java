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
	public String deleteDoctorById(Long id) {
		Doctor d = this.doctorRepo.findById(id).orElse(null);
		this.doctorRepo.deleteById(id);
		return "Id  "+d.getId()+" is"+" Deleted";
	}
	
	@Override
	public Doctor updateDoctors(Doctor doctor) {
		Doctor doctorUpdate=doctorRepo.findById(doctor.getMedicineCode())
				.orElse(null);
		existingMedicine.setMedicineName(pharm.getMedicineName());
		existingMedicine.setPrice(pharm.getPrice());
		existingMedicine.setQuantity(pharm.getQuantity());
		existingMedicine.setExpiry(pharm.getExpiry());
		existingMedicine.setManufacturerName(pharm.getManufacturerName());
		return pharmRepo.save(existingMedicine);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		 Doctor doctorToUpdate = doctorRepo.findById(doctor.getId()).orElse(null);
		 if(doctor.getPassword()!=null) {
			 doctorToUpdate.setPassword(doctor.getPassword()); 
		 }
		 if(doctor.getDoctorName()!=null) {
			 doctorToUpdate.setDoctorName(doctor.getDoctorName()); 
		 }
		 
		 if(doctor.getYearsOfExperience()!=0) {
			 doctorToUpdate.setYearsOfExperience(doctor.getYearsOfExperience()); 
		 }
		 if(doctor.getSpecialization()!=null) {
			 doctorToUpdate.setSpecialization(doctor.getSpecialization());
		 }
		 
		
		 return doctorRepo.save(doctorToUpdate);
	}



}

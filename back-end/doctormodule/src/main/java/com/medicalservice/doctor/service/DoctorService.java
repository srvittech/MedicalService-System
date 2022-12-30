package com.medicalservice.doctor.service;

import java.util.List;

import com.medicalservice.doctor.model.Doctor;

public interface DoctorService {

	public List<Doctor> getDoctors();

	public Doctor addDoctor(Doctor doctor);

	public Doctor updateDoctor(Doctor doctor);

	public Doctor findDoctorById(Long id);

	public String deleteDoctorById(Long id);

	public Doctor updateDoctors(Doctor doctor);

}

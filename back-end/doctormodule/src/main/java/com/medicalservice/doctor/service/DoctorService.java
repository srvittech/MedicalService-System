package com.medicalservice.doctor.service;

import java.util.List;

import com.medicalservice.doctor.model.Doctor;

public interface DoctorService {
	public List<Doctor> getDoctors();
	public void  addDoctor(Doctor doctor);
	public void updateDoctor(Doctor doctor);
	public Doctor findDoctorById(int id);
	public void deleteDoctorById(int id);

}

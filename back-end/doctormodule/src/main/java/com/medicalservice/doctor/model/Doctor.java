package com.medicalservice.doctor.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.medicalservice.doctor.repository.DoctorRepository;

@Document(collection = "Doctors")
public class Doctor {
	@Id
	private Long id;
	private String name;
	private String specialization;
	private boolean availability = false;
	private long mobile;
	private List<String> patientAssigned = new ArrayList<>();
	@Autowired
	DoctorRepository doctorRepo;

	public List<String> getPatientAssigned() {
		return patientAssigned;
	}

	public void setPatientAssigned(List<String> patientAssigned) {
		this.patientAssigned = patientAssigned;
	}

	public Long getId() {
		return id;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

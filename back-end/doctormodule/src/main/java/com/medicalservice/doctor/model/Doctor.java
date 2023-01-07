package com.medicalservice.doctor.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Doctors")
public class Doctor {
	@Transient
	public static final String SEQUENCE_NAME = "user_sequence";
	@Id
	private Long id;
	private String doctorName;
	private String password;
	private int yearsOfExperience;
	private String specialization;
	private String email;
    private Long mobile;
	private boolean availability = false;

	public Doctor() {

	}

	public Doctor(Long id, String doctorName, String password, int yearsOfExperience, String specialization,
			String email, Long mobile, boolean availability) {
		super();
		this.id = id;
		this.doctorName = doctorName;
		this.password = password;
		this.yearsOfExperience = yearsOfExperience;
		this.specialization = specialization;
		this.email = email;
		this.mobile = mobile;
		this.availability = availability;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}



	
}

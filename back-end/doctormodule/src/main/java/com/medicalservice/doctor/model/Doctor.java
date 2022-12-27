package com.medicalservice.doctor.model;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Doctor {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String specialization;
	private boolean availability = true;
	private Long mobile;
	private List doctorAssignedToPatient;
	public Doctor(){}
	public Doctor(int id, String name, String specialization, boolean availability, Long mobile,
			List doctorAssignedToPatient) {
		super();
		this.id = id;
		this.name = name;
		this.specialization = specialization;
		this.availability = availability;
		this.mobile = mobile;
		this.doctorAssignedToPatient = doctorAssignedToPatient;
	}
	public List getDoctorAssignedToPatient() {
		return doctorAssignedToPatient;
	}
	public void setDoctorAssignedToPatient(List doctorAssignedToPatient) {
		this.doctorAssignedToPatient = doctorAssignedToPatient;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", specialization=" + specialization + ", availability="
				+ availability + ", mobile=" + mobile + ", doctorAssignedToPatient=" + doctorAssignedToPatient + "]";
	}
	
	
	
	

}

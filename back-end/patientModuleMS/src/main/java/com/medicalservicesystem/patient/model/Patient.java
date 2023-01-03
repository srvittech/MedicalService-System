package com.medicalservicesystem.patient.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "Patient")
public class Patient {
	@Id
	@GeneratedValue(generator="patient_seq", strategy = GenerationType.AUTO)
	@SequenceGenerator(name="patient_seq",sequenceName="patient_seq",initialValue=5091753,allocationSize=1)
	private Long id;
	private String password;
	private String name;
	private int age;
	private String address;
	private String disease;
	private int weight;
	
	

	public Patient() {
		super();
	}

	public Patient(Long id, String password, String name, int age, String address, String disease,
			int weight) {
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.age = age;
		this.address = address;
		this.disease = disease;
		this.weight = weight;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId() {
		return id;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", password=" + password + ", name=" + name + ", age=" + age + ", address="
				+ address + ", disease=" + disease + ", weight=" + weight + "]";
	}


}

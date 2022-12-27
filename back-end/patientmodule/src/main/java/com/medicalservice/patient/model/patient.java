package com.medicalservice.patient.model;

public class Patient {
	private int id;
	private String name;
	private int age;
	private String address;
	private String disease;
	private String status;
	private int weight;
	public Patient(){}
	public Patient(int id, String name, int age, String address, String disease, String status, int weight) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.disease = disease;
		this.status = status;
		this.weight = weight;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", disease=" + disease
				+ ", status=" + status + ", weight=" + weight + "]";
	}
}




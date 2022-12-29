package com.medicalServiceSystem.transacation.service;

public interface TransacationService {

	public void addTransaction();

	public void getTransaction();

	public void getRequestBasedOnStatus();

	public void getByDoctorId();

	public void getByPatientId();

	public void updateStatus();

	public void updateTransacation();

}

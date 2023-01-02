package com.medicalservicesystem.patient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.medicalservicesystem.patient.model.Patient;
import com.medicalservicesystem.patient.repository.PatientRepository;
import com.medicalservicesystem.patient.service.PatientServiceImp;

@SpringBootTest
class PatientModuleMsApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	private PatientServiceImp patientServiceImp;

	@Mock
	private PatientRepository patientRepository;

	@Test
	public void  addPatientTest() {
		Patient patient =new Patient(1L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		when(patientRepository.save(patient)).thenReturn(patient);
		assertEquals(patient, patientServiceImp.addPatient(patient));
	}
	
	@Test
	public void deletePatientById() {
		Patient patient = new Patient(1L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		patientRepository.deleteById(patient.getId());
		assertEquals(null, patientServiceImp.findPatientById(1L));	
	}
	

	
	@Test
	public void findPatientByIdTest() {
		Patient patient = new Patient(1L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
		Patient expected = patientServiceImp.findPatientById(patient.getId());
		verify(patientRepository).findById(patient.getId());

	}
	
	@Test
	public void getPatientTest() {
		Patient patient = new Patient(1L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		when(patientRepository.findAll()).thenReturn(Stream.of(new Patient(1L, "password1", "lakshmi", 26, "hyderabad", "cold",70)).collect(Collectors.toList()));
		assertEquals(1, patientServiceImp.getPatient().size());
	}
	
	@Test
	public void updatePatientTest() {
		Patient patient = new Patient(1L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		Patient patient1 = new Patient(2L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		Patient patient2 = new Patient(3L, "password1", "lakshmi", 26, "hyderabad", "cold",70);
		Patient patient3 = new Patient(1L, "passwordCHECK", "lakshmi", 26, "hyderabad", "cold",70);
		when(patientRepository.findById(patient.getId())).thenReturn(Optional.of(patient));
		when(patientRepository.findById(patient1.getId())).thenReturn(Optional.of(patient1));
		when(patientRepository.findById(patient2.getId())).thenReturn(Optional.of(patient2));
		patientServiceImp.updatePatient(patient3);
		assertEquals(patient, patientServiceImp.findPatientById(1L));	
	}

}

package com.medicalservice.doctor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.repository.DoctorRepository;
import com.medicalservice.doctor.service.DoctorServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DoctormoduleApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private DoctorServiceImpl doctorServiceImp;
	@Mock
	private DoctorRepository doctorRepo;

	@Test
	public void addDoctorTest() {
		Doctor doctor = new Doctor(1L, "John", "password", 5, "Eye", false);
		when(doctorRepo.save(doctor)).thenReturn(doctor);
		assertEquals(doctor, doctorServiceImp.addDoctor(doctor));

	}

	@Test
	public void getDoctosTest() {
		Doctor doctor = new Doctor(1L, "John", "password", 5, "Eye", false);
		when(doctorRepo.findAll()).thenReturn(Stream.of(new Doctor(2L, "James", "password1", 4, "Heart", false),
				new Doctor(3L, "Bond", "password2", 3, "Neuro", true)).collect(Collectors.toList()));
		assertEquals(2, doctorServiceImp.getDoctors().size());
	}

	@Test
	public void findDoctorByIdTest() {
		Doctor doctor = new Doctor(1L, "John", "password", 5, "Eye", false);
		when(doctorRepo.findById(doctor.getId())).thenReturn(Optional.of(doctor));
		Doctor expected = doctorServiceImp.findDoctorById(doctor.getId());
		verify(doctorRepo).findById(doctor.getId());

	}
	
	@Test
	public void findBySpecializationTest() {
		List<Doctor> all = new LinkedList<>();

		all.add(new Doctor(1L, "John", "password", 5, "Eye", false));

		all.add(new Doctor(2L, "John1", "password", 5, "Eye", false));

		all.add(new Doctor(3L, "John2", "password", 5, "Eye", false));

		all.add(new Doctor(4L, "John3", "password", 5, "Eye", false));
		
		when(doctorRepo.findBySpecialization("Eye")).thenReturn(all);
		assertEquals(all,doctorServiceImp.findBySpecialization("Eye"));
		
	}


	@Test
	public void deleteDoctorByIdTest() {
		Doctor doctor = new Doctor(1L, "John", "password", 5, "Eye", false);
		doctorServiceImp.deleteDoctorById(doctor.getId());
		verify(doctorRepo, times(1)).deleteById(doctor.getId());
	}

	@Test
	public void updateDoctorTest() {
		Doctor doctor = new Doctor(1L, "John", "password", 5, "Eye", false);
		Doctor updatedDoctor = new Doctor(1L, "James", "password1", 5, "Eye", true);
		when(doctorRepo.findById(doctor.getId())).thenReturn(Optional.of(doctor));
		doctorServiceImp.updateDoctor(updatedDoctor);
		assertEquals(doctor,doctorServiceImp.findDoctorById(1L));	
	}
}

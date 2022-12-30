package com.medicalservicesystem.patient;

<<<<<<< HEAD
//import static org.junit.Assert.assertEquals;
=======
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
>>>>>>> origin/komali
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
		verify(patientRepository, times(1)).deleteById(patient.getId());	
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
	
	/*@Test
	public void updatePatientTest() {
		Blog blog = new Blog(1L,"test1");
		Blog blog1 = new Blog(2L,"test2");
		Blog blog2 = new Blog(3L,"test3");
		Blog blog3 = new Blog(1L,"test4");
		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
		blogServiceImpl.updateBlog(blog3);
		assertEquals(blog, blogServiceImpl.getBlog(1L));	
	}*/
<<<<<<< HEAD
=======
//	@InjectMocks
//	private PatientServiceImp patientServiceImp;
//
//	@Mock
//	private PatientRepository patientRepository;
//	
//
//	@Test
//	public void  addPatientTest() {
//		Patient patient =new Patient();
//		when(patientRepository.save(patient)).thenReturn(new Patient());
//		assertEquals(patient, patientServiceImp.addPatient(patient));
//	}
//	
//	@Test
//	public void deleteBlogById() {
//		Blog blog2 = new Blog(1L,"test3");
//		blogRepository.deleteById(blog2.getId());
//		assertEquals(null, blogServiceImpl.getBlog(1L));	
//	}
//	
//
<<<<<<< HEAD
//	public Patient findPatientById(Long id);
//
//	public void deletePatientById(Long id);

/*	@Test
	public void  addPatientTest() {
		Patient patient =new Patient();
		when(patientRepository.save(patient)).thenReturn(new Patient());
		assertEquals(patient, patientServiceImp.addPatient(patient));
	}
	
	@Test
	public void deleteBlogById() {
		Blog blog2 = new Blog(1L,"test3");
		blogRepository.deleteById(blog2.getId());
		assertEquals(null, blogServiceImpl.getBlog(1L));	
	}
	

	
	@Test
	public void findPatientByIdTest() {
		Blog blog = new Blog(1L,"test1");
		Blog blog1 = new Blog(2L,"test2");
		Blog blog2 = new Blog(3L,"test3");
		Blog blog3 = new Blog(4L,"test4");
		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
		when(blogRepository.findById(blog3.getId())).thenReturn(Optional.of(blog3));
		assertEquals(blog1, blogServiceImpl.getBlog((long) 2));	
	}
	@Test
	public void getPatientTest() {
		Blog blog = new Blog(1L,"test1");
		Blog blog1 = new Blog(2L,"test2");
		Blog blog2 = new Blog(3L,"test3");
		Blog blog3 = new Blog(4L,"test4");
		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
		when(blogRepository.findById(blog3.getId())).thenReturn(Optional.of(blog3));
		assertEquals(blog1, blogServiceImpl.getBlog((long) 2));	
	}
	@Test
	public void updatePatientTest() {
		Blog blog = new Blog(1L,"test1");
		Blog blog1 = new Blog(2L,"test2");
		Blog blog2 = new Blog(3L,"test3");
		Blog blog3 = new Blog(1L,"test4");
		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
		blogServiceImpl.updateBlog(blog3);
		assertEquals(blog, blogServiceImpl.getBlog(1L));	
	}
*/
=======
//	
//	@Test
//	public void findPatientByIdTest() {
//		Blog blog = new Blog(1L,"test1");
//		Blog blog1 = new Blog(2L,"test2");
//		Blog blog2 = new Blog(3L,"test3");
//		Blog blog3 = new Blog(4L,"test4");
//		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
//		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
//		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
//		when(blogRepository.findById(blog3.getId())).thenReturn(Optional.of(blog3));
//		assertEquals(blog1, blogServiceImpl.getBlog((long) 2));	
//	}
//	@Test
//	public void getPatientTest() {
//		Blog blog = new Blog(1L,"test1");
//		Blog blog1 = new Blog(2L,"test2");
//		Blog blog2 = new Blog(3L,"test3");
//		Blog blog3 = new Blog(4L,"test4");
//		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
//		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
//		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
//		when(blogRepository.findById(blog3.getId())).thenReturn(Optional.of(blog3));
//		assertEquals(blog1, blogServiceImpl.getBlog((long) 2));	
//	}
//	@Test
//	public void updatePatientTest() {
//		Blog blog = new Blog(1L,"test1");
//		Blog blog1 = new Blog(2L,"test2");
//		Blog blog2 = new Blog(3L,"test3");
//		Blog blog3 = new Blog(1L,"test4");
//		when(blogRepository.findById(blog.getId())).thenReturn(Optional.of(blog));
//		when(blogRepository.findById(blog1.getId())).thenReturn(Optional.of(blog1));
//		when(blogRepository.findById(blog2.getId())).thenReturn(Optional.of(blog2));
//		blogServiceImpl.updateBlog(blog3);
//		assertEquals(blog, blogServiceImpl.getBlog(1L));	
//	}
>>>>>>> origin/sourav
=======
>>>>>>> origin/sourav

>>>>>>> origin/sourav
}

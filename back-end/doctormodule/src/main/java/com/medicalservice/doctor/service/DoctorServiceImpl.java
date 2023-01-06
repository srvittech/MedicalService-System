package com.medicalservice.doctor.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.medicalservice.doctor.model.DatabaseSequence;
import com.medicalservice.doctor.model.Doctor;
import com.medicalservice.doctor.repository.DoctorRepository;

@Service
public class DoctorServiceImpl implements DoctorService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorServiceImpl.class);
	@Autowired
	DoctorRepository doctorRepo;
	
	@Autowired
	private MongoOperations mongoOperations;
	
	public Long generateSequence(String seqName) {

		DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 693489), options().returnNew(true).upsert(true), DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	@Override
	public List<Doctor> getDoctors() {
		LOGGER.info("Getting All Doctors From DoctorService.....");
		return doctorRepo.findAll();
	}

	@Override
	public Doctor addDoctor(Doctor doctor) {
		LOGGER.info("Adding Doctor From DoctorService.....");
		return doctorRepo.save(doctor);
	}

	@Override
	public Doctor findDoctorById(Long id) {
		LOGGER.info("Getting Doctor By Id From DoctorService.....");
		return doctorRepo.findById(id).orElse(null);
	}
	
	@Override
	public List<Doctor> findBySpecialization(String specialization){
		LOGGER.info("Getting All Doctors By Specialization From DoctorService.....");
		return doctorRepo.findBySpecialization(specialization);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		 Doctor doctorToUpdate = doctorRepo.findById(doctor.getId()).orElse(null);
		 if(doctor.getPassword()!=null) {
			 LOGGER.info("Updating Doctor Password From DoctorService.....");
			 doctorToUpdate.setPassword(doctor.getPassword()); 
		 }
		 if(doctor.getDoctorName()!=null) {
			 LOGGER.info("Updating Doctor Name From DoctorService.....");
			 doctorToUpdate.setDoctorName(doctor.getDoctorName()); 
		 }
		 
		 if(doctor.getYearsOfExperience()!=0) {
			 LOGGER.info("Updating YearsOfExperience From DoctorService.....");
			 doctorToUpdate.setYearsOfExperience(doctor.getYearsOfExperience()); 
		 }
		 if(doctor.getSpecialization()!=null) {
			 LOGGER.info("Updating Doctor Specialization From DoctorService.....");
			 doctorToUpdate.setSpecialization(doctor.getSpecialization());
		 }
		 
		return doctorRepo.save(doctorToUpdate);
	}

	@Override
	public void deleteDoctorById(Long id) {
		LOGGER.info("Deleting  Doctor Id From DoctorService.....");
		doctorRepo.deleteById(id);
		
	}



}

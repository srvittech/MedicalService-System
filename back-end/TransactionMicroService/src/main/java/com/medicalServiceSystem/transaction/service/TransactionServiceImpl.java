package com.medicalServiceSystem.transaction.service;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.medicalServiceSystem.transaction.model.DatabaseSequence;
import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.repository.TransactionRepository;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class TransactionServiceImpl implements TransactionService {
	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	TransactionRepository transactionRepo;

	@Autowired
	private MongoOperations mongoOperations;

	public Long generateSequence(String seqName) {

		DatabaseSequence counter = mongoOperations.findAndModify(query(where("_id").is(seqName)),
				new Update().inc("seq", 1), options().returnNew(true).upsert(true), DatabaseSequence.class);
		return !Objects.isNull(counter) ? counter.getSeq() : 1;

	}

	@Override
	public Transaction addTransaction(Transaction transaction) {
		LOGGER.info("Adding Transactions From TransactionService.....");
		transaction.setTransactionId(generateSequence(Transaction.SEQUENCE_NAME));
		return transactionRepo.save(transaction);
	}


	@Override
	public List<Transaction> getAllTransaction() {
		LOGGER.info("Getting All Transactions From TransactionService.....");
		return transactionRepo.findAll();
	}

	@Override
	public List<Transaction> getTransactionBasedOnStatus(String status) {
		LOGGER.info("Getting All Transactions By Status From TransactionService.....");
		return transactionRepo.getTransactionBasedOnStatus(status);
	}

	@Override
	public List<Transaction> getTransactionByDoctorId(Long doctorId) {
		LOGGER.info("Getting All Transactions By Doctor Id From TransactionService.....");
		return transactionRepo.getTransactionByDoctorId(doctorId);
	}

	@Override
	public List<Transaction> getTransactionByPatientId(Long patientId) {
		LOGGER.info("Getting Transactions By Patient Id From TransactionService.....");
		return transactionRepo.getTransactionByPatientId(patientId);
	}

	@Override
	public Transaction getTransactionByTransactionId(Long transactionId) {
		LOGGER.info("Getting Transaction By Transaction Id From TransactionService.....");
		return transactionRepo.findById(transactionId).orElse(null);
	}

	@Override
	public Transaction updateTransaction(Transaction transaction) {
		Transaction transactionToUpdate = transactionRepo.findById(transaction.getTransactionId()).orElse(null);
		if (transaction.getDoctorId() != null) {
			LOGGER.info("Updating Doctor Id From TransactionService.....");
			transactionToUpdate.setDoctorId(transaction.getDoctorId());
		}
		if (transaction.getPatientId() != null) {
			LOGGER.info("Updating Patient Id From TransactionService.....");
			transactionToUpdate.setPatientId(transaction.getPatientId());
		}
		if (transaction.getDisease() != null) {
			LOGGER.info("Updating Disease From TransactionService.....");
			transactionToUpdate.setDisease(transaction.getDisease());
		}
		if (transaction.getStatus() != null) {
			LOGGER.info("Updating Status From TransactionService.....");
			transactionToUpdate.setStatus(transaction.getStatus());
		}
		if (transaction.getDateOfRequest() != null) {
			LOGGER.info("Updating DateOfRequest From TransactionService.....");
			transactionToUpdate.setDateOfRequest(transaction.getDateOfRequest());
		}
		if (transaction.getDateOfTreatment() != null) {
			LOGGER.info("Updating DateOfTreatment From TransactionService.....");
			transactionToUpdate.setDateOfTreatment(transaction.getDateOfTreatment());
		}
		if (transaction.getPrescription() != null) {
			LOGGER.info("Updating Prescription From TransactionService.....");
			transactionToUpdate.setPrescription(transaction.getPrescription());
		}
		if (transaction.getDoctorName() != null) {
			LOGGER.info("Updating DoctorName From TransactionService.....");
			transactionToUpdate.setDoctorName(transaction.getDoctorName());
		}

		if (transaction.getDoctorSpecialization() != null) {
			LOGGER.info("Updating DoctorSpecialization From TransactionService.....");
			transactionToUpdate.setDoctorSpecialization(transaction.getDoctorSpecialization());
		}
		if (transaction.getFeedback() != null) {
			LOGGER.info("Updating Feedback From TransactionService.....");
			transactionToUpdate.setFeedback(transaction.getFeedback());
		}
		if (transaction.getDateOfExpectedApointment() != null) {
			LOGGER.info("Updating Feedback From TransactionService.....");
			transactionToUpdate.setDateOfExpectedApointment(transaction.getDateOfExpectedApointment());
		}
		LOGGER.info("Saving Update From TransactionService.....");
		return transactionRepo.save(transactionToUpdate);
	}

}

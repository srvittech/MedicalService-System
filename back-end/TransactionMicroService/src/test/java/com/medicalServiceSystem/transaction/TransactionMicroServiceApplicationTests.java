package com.medicalServiceSystem.transaction;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.repository.TransactionRepository;
import com.medicalServiceSystem.transaction.service.TransactionServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class TransactionMicroServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private TransactionServiceImpl transactionServiceImp;
	@Mock
	private TransactionRepository transactionRepository;

	@Test
	public void addTransactionTest() {

		Transaction transaction = new Transaction();

		when(transactionRepository.save(transaction)).thenReturn(transaction);

		assertEquals(transaction, transactionServiceImp.addTransaction(transaction));

	}

	@Test
	public void getAllTransactionTest() {

		List<Transaction> all = new LinkedList<>();

		all.add(new Transaction(1L, 2L, 3L, "FEVER", "PENDING", "PARACETAMOL", "12-12-2022", "13-12-2022"));

		all.add(new Transaction(5L, 2L, 3L, "FEVER", "PENDING", "PARACETAMOL", "12-12-2022", "13-12-2022"));

		all.add(new Transaction(6L, 2L, 3L, "FEVER", "PENDING", "PARACETAMOL", "12-12-2022", "13-12-2022"));

		all.add(new Transaction(8L, 2L, 3L, "FEVER", "PENDING", "PARACETAMOL", "12-12-2022", "13-12-2022"));

		when(transactionRepository.findAll()).thenReturn(all);

		assertEquals(all, transactionServiceImp.getAllTransaction());

	}

	@Test
	public void getTransactionBasedOnStatusTest() {

		List<Transaction> all = new LinkedList<>();

		all.add(new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(5L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(6L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(8L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
		Transaction transaction=new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022");

		when(transactionRepository.getTransactionBasedOnStatus("PENDING")).thenReturn(all);
		assertEquals(all, transactionServiceImp.getTransactionBasedOnStatus("PENDING"));	
	}

	@Test
	public void getTransactionByDoctorIdTest() {

		List<Transaction> all = new LinkedList<>();

		all.add(new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(5L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(6L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(8L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		when(transactionRepository.getTransactionByDoctorId(3L)).thenReturn(all);
		assertEquals(all, transactionServiceImp.getTransactionByDoctorId(3L));
	}

	@Test
	public void  getTransactionByPatientIdTest() {
		List<Transaction> all = new LinkedList<>();

		all.add(new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(5L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(6L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		all.add(new Transaction(8L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));

		when(transactionRepository. getTransactionByPatientId(2L)).thenReturn(all);
		assertEquals(all, transactionServiceImp.getTransactionByPatientId(2L));
	}

	@Test
	public void getTransactionByTransactionIdTest() {
		Transaction transaction = new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022");
		when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
		assertEquals(transaction, transactionServiceImp.getTransactionByTransactionId(1L));
	}

	@Test
	public void updateTransactionTest() {
		Transaction transaction = new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022");
		Transaction updatedTransaction = new Transaction(1L,6L,9L,"high FEVER","Accepted","PARACETAMOL","12-12-2022","13-12-2022");
		when(transactionRepository.findById(transaction.getTransactionId())).thenReturn(Optional.of(transaction));
		 transactionServiceImp.updateTransaction(updatedTransaction);
		assertEquals(transaction,   transactionServiceImp.getTransactionByTransactionId(1L));	
	}

}

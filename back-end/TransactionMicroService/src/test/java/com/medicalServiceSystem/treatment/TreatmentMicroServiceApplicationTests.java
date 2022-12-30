package com.medicalServiceSystem.treatment;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.RequestBody;

import com.medicalServiceSystem.transaction.model.Transaction;
import com.medicalServiceSystem.transaction.repository.TransactionRepository;
import com.medicalServiceSystem.transaction.service.TransactionServiceImpl;


@SpringBootTest
class TreatmentMicroServiceApplicationTests {
	

	@Test
	void contextLoads() {
	}
	@InjectMocks
	private TransactionServiceImpl transactionServiceImp;
	@Mock
	private TransactionRepository transactionRepository;
	

//	@Test
//	public void  addTransactionTest() {
//		Transaction transaction =new Transaction();
//		when(transactionRepository.save(transaction)).thenReturn(transaction);
//		assertEquals(transaction, transactionServiceImp.addTransaction(transaction));
//	}
//	
//	@Test
//	public void  getAllTransactionTest() {
//		
//		List<Transaction> all = new ArrayList();
//		all.add(new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		all.add(new Transaction(5L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		all.add(new Transaction(6L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		all.add(new Transaction(8L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		when(transactionRepository.findAll()).thenReturn(all);
//		assertEquals(all, transactionServiceImp.getAllTransaction());
//	}
	 
	
//	@Test
//	public void getTransactionBasedOnStatusTest() {
//
//		List<Transaction> all = new ArrayList();
//		all.add(new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		all.add(new Transaction(5L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		all.add(new Transaction(6L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		all.add(new Transaction(8L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022"));
//		Transaction transaction=new Transaction(1L,2L,3L,"FEVER","PENDING","PARACETAMOL","12-12-2022","13-12-2022");
//		when(transactionRepository.getTransactionBasedOnStatus("PENDING").thenReturn(all);
//		assertEquals(all, transactionServiceImp.getTransactionBasedOnStatus("PENDING"));	
//	}
	

//	
//	@Test
//	public void getTransactionByDoctorIdTest() {
//		transaction transaction = new transaction(1L,"test1");
//		transaction transaction1 = new transaction(2L,"test2");
//		transaction transaction2 = new transaction(3L,"test3");
//		transaction transaction3 = new transaction(4L,"test4");
//		when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));
//		when(transactionRepository.findById(transaction1.getId())).thenReturn(Optional.of(transaction1));
//		when(transactionRepository.findById(transaction2.getId())).thenReturn(Optional.of(transaction2));
//		when(transactionRepository.findById(transaction3.getId())).thenReturn(Optional.of(transaction3));
//		assertEquals(transaction1, transactionServiceImp.gettransaction((long) 2));	
//	}
//	
//	@Test
//	public void getTransactionBytransactionIdTest() {
//		transaction transaction = new transaction(1L,"test1");
//		transaction transaction1 = new transaction(2L,"test2");
//		transaction transaction2 = new transaction(3L,"test3");
//		transaction transaction3 = new transaction(4L,"test4");
//		when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));
//		when(transactionRepository.findById(transaction1.getId())).thenReturn(Optional.of(transaction1));
//		when(transactionRepository.findById(transaction2.getId())).thenReturn(Optional.of(transaction2));
//		when(transactionRepository.findById(transaction3.getId())).thenReturn(Optional.of(transaction3));
//		assertEquals(transaction1, transactionServiceImp.gettransaction((long) 2));	
//	}
//	
//	 
//	
//	@Test
//	public void getTransactionByTransactionIdTest() {
//		Transaction transaction = new transaction(1L,"test1");
//		Transaction transaction1 = new transaction(2L,"test2");
//		Transaction transaction2 = new transaction(3L,"test3");
//		Transaction transaction3 = new transaction(4L,"test4");
//		when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));
//		when(transactionRepository.findById(transaction1.getId())).thenReturn(Optional.of(transaction1));
//		when(transactionRepository.findById(transaction2.getId())).thenReturn(Optional.of(transaction2));
//		when(transactionRepository.findById(transaction3.getId())).thenReturn(Optional.of(transaction3));
//		assertEquals(transaction1, transactionServiceImp.gettransaction((long) 2));	
//	}
//	@Test
//	public void updatetransactionTest() {
//		transaction transaction = new transaction(1L,"test1");
//		transaction transaction1 = new transaction(2L,"test2");
//		transaction transaction2 = new transaction(3L,"test3");
//		transaction transaction3 = new transaction(1L,"test4");
//		when(transactionRepository.findById(transaction.getId())).thenReturn(Optional.of(transaction));
//		when(transactionRepository.findById(transaction1.getId())).thenReturn(Optional.of(transaction1));
//		when(transactionRepository.findById(transaction2.getId())).thenReturn(Optional.of(transaction2));
//		transactionServiceImpl.updatetransaction(transaction3);
//		assertEquals(transaction, transactionServiceImp.gettransaction(1L));	
//	}


}

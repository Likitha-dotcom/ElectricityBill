package com.capgemini.eb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.repository.ICustomerRepository;


@ExtendWith(SpringExtension.class)
public class CustomerServiceMockitoTest {
	
	@InjectMocks
	CustomerServiceImpl custServ;
		
	// @MockBean - Creates Mock of a class or interface
	@MockBean
	ICustomerRepository custRepo;
		
	// Initialization of mock objects
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void registerCustomerTest() {
		Customer cust = new Customer();
		cust.setCustomerId(5);
		cust.setFirstName("Keerti");
		cust.setAddharNumber(000011112222L);
		cust.setEmail("keerti@gmail.com");
		
		Mockito.when(custRepo.save(cust)).thenReturn(cust);
		Customer testNewCust = custServ.registerCustomer(cust);
	
		assertEquals(5, testNewCust.getCustomerId());
		assertEquals("Keerti", testNewCust.getFirstName());
		assertEquals(000011112222L, testNewCust.getAddharNumber());
		assertEquals("keerti@gmail.com", testNewCust.getEmail());
	}
	
	@Test
	void searchCustomerByCustomerIdTest(){
		Customer cust = new Customer();
		cust.setCustomerId(10);
		cust.setFirstName("Rohit");
		cust.setAddharNumber(000011112222L);
		cust.setEmail("rohit@gmail.com");
		
		Mockito.when(custRepo.findById(10)).thenReturn(Optional.of(cust));
		Customer testCust = custServ.searchCustomerByCustomerId(10);
	
		assertEquals(10, testCust.getCustomerId());
		assertEquals("Rohit", testCust.getFirstName());
		assertEquals(000011112222L, testCust.getAddharNumber());
		assertEquals("rohit@gmail.com", testCust.getEmail());
	}

}

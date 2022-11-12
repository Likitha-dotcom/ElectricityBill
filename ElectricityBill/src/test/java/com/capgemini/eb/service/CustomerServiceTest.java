package com.capgemini.eb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.eb.dto.CustomerOutputDto;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.exceptions.NoSuchCustomerException;


@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	ICustomerService custServ;
	
	@Test
	void viewCustomerProfileTest() {
		CustomerOutputDto customer = custServ.viewCustomerProfile(1);
		assertEquals(123412341234L, customer.getAddharNumber());
		assertEquals("lixi@gmail.com", customer.getEmail());
		assertEquals("Likitha", customer.getFirstName());
		assertEquals("female", customer.getGender());
		assertEquals(9035209167L, customer.getMobileNumber());
	}
	
	@Test
	void searchByCustomerIdTest(){
		Customer customer = custServ.searchCustomerByCustomerId(2);
		assertEquals(111122225555L, customer.getAddharNumber());
		assertEquals("ankit@gmail.com", customer.getEmail());
		assertEquals("Ankit", customer.getFirstName());
		assertEquals("male", customer.getGender());
		assertEquals(9980088886L, customer.getMobileNumber());
	}
	
	@Test
	void searchCustomerByAadharTest() {
		Customer customer = custServ.searchCustomerByAadhar(404050506061L);
		assertEquals(404050506061L, customer.getAddharNumber());
		assertEquals("mishar1@gmail.com", customer.getEmail());
		assertEquals("Misha", customer.getFirstName());
		assertEquals("others", customer.getGender());
	}
	
	@Test
	void NoSuchCustomerExceptionTest() {
		NoSuchCustomerException ex=assertThrows(NoSuchCustomerException.class, ()->{
			custServ.searchCustomerByCustomerId(1000);
		});
		assertTrue(ex.getMessage().contains("Customer not found with ID:1000"));
	}
	
}

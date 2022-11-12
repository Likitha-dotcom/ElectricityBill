package com.capgemini.eb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.eb.dto.CustomerInputDto;
import com.capgemini.eb.dto.CustomerOutputDto;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.service.ICustomerService;


@RestController //to denote controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService custServ;
	
	//add new customer
	@PostMapping("/register")
	ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) {
		Customer newCust = custServ.registerCustomer(customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Customer registered successfully.");
		return new ResponseEntity<>(newCust,headers,HttpStatus.CREATED); // status code 201;	
	}
	
	//view customer details
	@GetMapping("/viewProfile/{customerId}")
	ResponseEntity<CustomerOutputDto> viewCustomerProfile(@PathVariable int customerId) {
		CustomerOutputDto cust = custServ.viewCustomerProfile(customerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This customer is available in the database.");
		return new ResponseEntity<CustomerOutputDto>(cust,headers,HttpStatus.OK); // status 200;
	}
	
	//edit customer details
	@PutMapping("/editProfile/{customerId}")
	ResponseEntity<CustomerOutputDto> editCustomerProfile(@PathVariable int customerId,@Valid @RequestBody CustomerInputDto customer) {
		CustomerOutputDto newCust = custServ.editCustomerProfile(customerId,customer);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This customer profile edited successfully.");
		return new ResponseEntity<>(newCust,headers,HttpStatus.OK); // status 200
	}
	
	// get customer by ID
	@GetMapping("/searchByCustomerId/{customerId}")
	ResponseEntity<Customer> searchCustomerByCustomerId(@PathVariable int customerId) {
		Customer getCust = custServ.searchCustomerByCustomerId(customerId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This customer is available in the database.");
		return new ResponseEntity<>(getCust,headers,HttpStatus.OK); // status 200
	}
	
	// Get customer by name
	@GetMapping("/searchByName/{firstName}")
	ResponseEntity<List<Customer>> searchCustomerByName(@PathVariable("firstName") String name) {
		List<Customer> custList = custServ.searchCustomerByName(name);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This customer name is available in the database.");
		return new ResponseEntity<>(custList,headers,HttpStatus.OK); // status 200
	}
	
	//get customer by email ID
	@GetMapping("/searchByEmail/{email}")
	ResponseEntity<Customer> searchCustomerByEmail(@PathVariable String email) {
		Customer cust = custServ.searchCustomerByEmail(email);
		return new ResponseEntity<>(cust,HttpStatus.OK); // status 200
	}
	
	//get customer by aadhar no
	@GetMapping("/searchByAadhar/{aadharNumber}")
	ResponseEntity<Customer> searchCustomerByAadhar(@PathVariable Long aadharNumber) {
		Customer cust = custServ.searchCustomerByAadhar(aadharNumber);
		return new ResponseEntity<>(cust,HttpStatus.OK); // status 200
	}
	
	//get customer by mobile no
	@GetMapping("/searchByMobile/{mobile}")
	ResponseEntity<Customer> searchCustomerByMobile(@PathVariable Long mobile) {
		Customer cust = custServ.searchCustomerByMobile(mobile);
		return new ResponseEntity<>(cust,HttpStatus.OK); // status 200
	}
}

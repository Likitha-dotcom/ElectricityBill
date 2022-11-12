package com.capgemini.eb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.eb.dto.CustomerInputDto;
import com.capgemini.eb.dto.CustomerOutputDto;
import com.capgemini.eb.entity.Customer;
import com.capgemini.eb.entity.Users;
import com.capgemini.eb.exceptions.DuplicateCustomerException;
import com.capgemini.eb.exceptions.NoSuchCustomerException;
import com.capgemini.eb.repository.ICustomerRepository;
import com.capgemini.eb.repository.IUserRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepository custRepo ;
	
	@Autowired
	IUserRepository userRepo;
	//IUserRepository userRepo;

	@Override
	public Customer registerCustomer(Customer customer) {
		// Add customer to DB
		if (null != custRepo.findById(customer.getCustomerId()))
			return custRepo.save(customer);
		else
			throw new  DuplicateCustomerException("This customer is already registered!");
	}

	@Override
	public CustomerOutputDto viewCustomerProfile(int customerId) {
		Optional<Customer> opt = custRepo.findById(customerId);
		if(opt.isPresent()) {
			//Read customer object from Optional
			Customer cust = opt.get();
			
			CustomerOutputDto resCustDto = new CustomerOutputDto();
			resCustDto.setUserId(cust.getUsers().getUserId());
			resCustDto.setCustomerId(cust.getCustomerId());
			resCustDto.setAddharNumber(cust.getAddharNumber());
			resCustDto.setFirstName(cust.getFirstName());
			resCustDto.setMiddleName(cust.getMiddleName());
			resCustDto.setLastName(cust.getLastName());
			resCustDto.setMobileNumber(cust.getMobileNumber());
			resCustDto.setEmail(cust.getEmail());
			resCustDto.setGender(cust.getGender());
			return resCustDto;
			
		}else {
			throw new NoSuchCustomerException("Customer not found with ID:"+customerId);
		}
	}

	@Override
	public CustomerOutputDto editCustomerProfile(int customerId,CustomerInputDto custDto) {
		Optional<Customer> opt = custRepo.findById(customerId);
		Optional<Users> opt1 = userRepo.findById(custDto.getUserId());
		if(opt.isPresent()&&opt1.isPresent()) {
			System.out.println(opt);
			System.out.println(opt1);
			
			//update
			Customer cust = new Customer();
			cust.setCustomerId(custDto.getCustomerId());
			cust.setAddharNumber(custDto.getAddharNumber());
			cust.setFirstName(custDto.getFirstName());
			cust.setMiddleName(custDto.getMiddleName());
			cust.setLastName(custDto.getLastName());
			cust.setMobileNumber(custDto.getMobileNumber());
			cust.setEmail(custDto.getEmail());
			cust.setGender(custDto.getGender());

			cust.setUsers(opt1.get());
			System.out.println(cust);
			
			Customer newCust = custRepo.save(cust);
			System.out.println(newCust);
		
			//convert newCust to DTO
			CustomerOutputDto resCustDto = new CustomerOutputDto();
			resCustDto.setUserId(newCust.getUsers().getUserId());
			resCustDto.setCustomerId(newCust.getCustomerId());
			resCustDto.setAddharNumber(newCust.getAddharNumber());
			resCustDto.setFirstName(newCust.getFirstName());
			resCustDto.setMiddleName(newCust.getMiddleName());
			resCustDto.setLastName(newCust.getLastName());
			resCustDto.setMobileNumber(newCust.getMobileNumber());
			resCustDto.setEmail(newCust.getEmail());
			resCustDto.setGender(newCust.getGender());
			
			return resCustDto;
			
		}else {
			throw new NoSuchCustomerException("Customer not found with ID:"+customerId);
		}
	}

	@Override
	public Customer searchCustomerByCustomerId(int customerId) {
		Optional<Customer> opt = custRepo.findById(customerId);
		Customer cust=null;
		if(opt.isPresent()) {
			//Read employee obj from Optional
			cust = opt.get();
						
		}else {
			throw new NoSuchCustomerException("Customer not found with ID:"+customerId);
		}
		return cust;
	}

	@Override
	public Customer searchCustomerByEmail(String email) {
		if(custRepo.existsByEmail(email))
			return custRepo.searchCustomerByEmail(email);
		else
			throw new NoSuchCustomerException("Customer not found with Email ID :"+email);
	}

	@Override
	public Customer searchCustomerByAadhar(Long aadharNumber) {
		if(custRepo.existsByAddharNumber(aadharNumber))
			return custRepo.searchCustomerByAddharNumber(aadharNumber);
		else
			throw new NoSuchCustomerException("Customer not found with Aadhar:"+aadharNumber);
	}

	@Override
	public Customer searchCustomerByMobile(Long mobile) {
		if(custRepo.existsByMobileNumber(mobile))
			return custRepo.findByMobileNumber(mobile);
		else
			throw new NoSuchCustomerException("Customer not found with mobile:"+mobile);
	}

	@Override
	public List<Customer> searchCustomerByName(String customerName) {
		if(custRepo.existsByfirstName(customerName))
			return custRepo.findByFirstName(customerName);
		else
			throw new NoSuchCustomerException("Customer not found with name :"+customerName);
	}

//	@Override
//	public CustomerOutputDto addCustomer(CustomerInputDto custDto) {
//		
//		Users user = new Users();
//		user.setUserName(custDto.getUserName());
//		
//		Customer cust = new Customer();
//		cust.setCustomerId(custDto.getCustomerId());
//		cust.setAddharNumber(custDto.getAddharNumber());
//		cust.setFirstName(custDto.getFirstName());
//		cust.setMiddleName(custDto.getMiddleName());
//		cust.setLastName(custDto.getLastName());
//		cust.setMobileNumber(custDto.getMobileNumber());
//		cust.setEmail(custDto.getEmail());
//		cust.setGender(custDto.getGender());
//		
//		cust.setUsers(user);
//		
//		Customer newCust = custRepo.save(cust);
//		
//		//convert newCust to DTO
//		CustomerOutputDto resCustDto = new CustomerOutputDto();
//		resCustDto.setUserId(newCust.getUsers().getUserId());
//		resCustDto.setCustomerId(newCust.getCustomerId());
//		resCustDto.setAddharNumber(newCust.getAddharNumber());
//		resCustDto.setFirstName(newCust.getFirstName());
//		resCustDto.setMiddleName(newCust.getMiddleName());
//		resCustDto.setLastName(newCust.getLastName());
//		resCustDto.setMobileNumber(newCust.getMobileNumber());
//		resCustDto.setEmail(newCust.getEmail());
//		resCustDto.setGender(newCust.getGender());
//		
//		return resCustDto;
//	}

}

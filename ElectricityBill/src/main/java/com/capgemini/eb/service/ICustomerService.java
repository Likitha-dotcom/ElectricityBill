package com.capgemini.eb.service;

import java.util.List;

import com.capgemini.eb.dto.CustomerInputDto;
import com.capgemini.eb.dto.CustomerOutputDto;
import com.capgemini.eb.entity.Customer;

public interface ICustomerService {
	//Abstract methods
	// all methods listed below throws NoSuchCustomerException
	public Customer registerCustomer(Customer customer); //done
	public CustomerOutputDto viewCustomerProfile(int customerId); //done
	//partially done (password getting reset)
	public CustomerOutputDto editCustomerProfile(int customerId,CustomerInputDto customer);
	public Customer searchCustomerByCustomerId(int customerId); //done
	public Customer searchCustomerByEmail(String email);	//done
	public Customer searchCustomerByAadhar(Long aadharNumber);	//done 
	public Customer searchCustomerByMobile(Long mobile);	//done 
	public List<Customer> searchCustomerByName(String customerName); //done 
}

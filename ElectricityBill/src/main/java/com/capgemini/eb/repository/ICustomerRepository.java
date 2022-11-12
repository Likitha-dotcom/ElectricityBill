package com.capgemini.eb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.eb.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	List<Customer> findByFirstName(String name);
	public Customer findByMobileNumber(Long mobileNumber);
	public Customer searchCustomerByAddharNumber(Long addharNumber);
	public Customer searchCustomerByEmail(String email);
	
	boolean existsByMobileNumber(Long mobile);
	boolean existsByAddharNumber(Long addharNumber);
	boolean existsByEmail(String email);
	boolean existsByfirstName(String firstName);
	
}

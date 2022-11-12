package com.capgemini.eb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.eb.entity.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer>{

	public abstract Users findByUserName(String userName);
	

}

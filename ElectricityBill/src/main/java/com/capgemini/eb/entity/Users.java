package com.capgemini.eb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(unique=true)
	@NotNull(message="User name must not be null")
	@Email
	private String userName;
	
	// you as developer define password complexity
	@Pattern(regexp="^[a-zA-Z0-9@#$%^&]+${3,8}",message="password length must be between 3-8 chars and must have special chars")
	private String password;

}

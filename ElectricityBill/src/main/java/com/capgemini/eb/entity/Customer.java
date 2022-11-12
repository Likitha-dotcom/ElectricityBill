package com.capgemini.eb.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(unique=true,length = 16)
	@NotNull(message="Aadhar number must not be null")
	private Long addharNumber;
	 
	@Column(name="firstName", length = 25)
	@NotNull(message="firstName must not be null")
	@Pattern(regexp="^[a-zA-Z]+$",message="First name should have only alphabets")
	private String firstName;
	 
	@Column(name="middleName", length = 25)
	private String middleName;
	
	@Column(name="lastName", length = 25)
	@Pattern(regexp="^[a-zA-Z]+$",message="Last name should have only alphabets")
	private String lastName;
	
	@Column(unique=true,length = 10)
	@NotNull(message="Mobile number must not be null")
	private Long mobileNumber;
	 
	@Column(name="email",unique = true)
	@Email
	@NotNull(message="email must not be null")
	private String email;
	 
	@Column(name = "gender",columnDefinition = "varchar(6) Check(gender IN ('male','female','others'))")
	@NotNull(message="gender must not be null")
	private String gender;
	
	//one to one relationship 
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Users users;
}

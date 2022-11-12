package com.capgemini.eb.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class CustomerInputDto {
	private int userId;
	@NotNull(message="User name must not be null")
//	@Email
//	private String userName;
	private int customerId;
	@NotNull(message="Aadhar number must not be null")
	private Long addharNumber;
	
	@NotNull(message="firstName must not be null")
	@Pattern(regexp="^[a-zA-Z]+$",message="First name should have only alphabets")
	private String firstName;
	
	private String middleName;
	
	@Pattern(regexp="^[a-zA-Z]+$",message="Last name should have only alphabets")
	private String lastName;
	
	@NotNull(message="Mobile number must not be null")
	private Long mobileNumber;
	
	@Email
	@NotNull(message="email must not be null")
	private String email;
	
	@NotNull(message="gender must not be null")
	private String gender;
}

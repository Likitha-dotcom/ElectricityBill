package com.capgemini.eb.dto;

import lombok.Data;

@Data
public class CustomerOutputDto {
	private int userId;
	private int customerId;
	private Long addharNumber;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long mobileNumber;
	private String email;
	private String gender;
}

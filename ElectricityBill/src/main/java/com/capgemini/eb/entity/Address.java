package com.capgemini.eb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id //make ID as primary key
	@GeneratedValue(strategy = GenerationType.AUTO) //it selects a generation strategy based on the database specific dialect
	private Long addressId;
	
	@Column(name="flat_number" , length=25) //sets column name and length
	@Pattern(regexp="[0-9]{8}",message="Please enter valid Flat no")
	private int flatOrHouseNumber;
	
	@Column(name="building_name" , length=25)
	private String buildingName;
	
	@Column(name="land_mark" , length=25)
	private String landmark;
	
	@Column(name="village" , length=25)
	private String village;
	
	@Column(name="taluka" , length=25)
	private String taluka;
	
	@Column(name="district" , length=25)
	private String districtName;
	
	@Column(name="state" , length=25)
	private String state;
	
	@Column(name="pincode" , length=25)
	@Pattern(regexp="[0-9]{5}",message="Please enter valid pincode")
	private String pincode;

}

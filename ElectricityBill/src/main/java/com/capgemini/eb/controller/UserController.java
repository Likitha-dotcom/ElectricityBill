package com.capgemini.eb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.eb.entity.Users;
import com.capgemini.eb.exceptions.DuplicateUserException;
import com.capgemini.eb.exceptions.InvalidLoginCredentialException;
import com.capgemini.eb.exceptions.NoSuchUserException;
import com.capgemini.eb.service.IUserService;
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	IUserService userServ;
	
	@PostMapping("/register")
	public ResponseEntity<Users> register(@Valid @RequestBody Users user) throws DuplicateUserException{
		Users newUser = userServ.registerUser(user);
		return new ResponseEntity<Users>(userServ.registerUser(newUser),HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> login(@Valid @RequestBody Users user) throws InvalidLoginCredentialException{
		Users newUser = userServ.loginUser(user);
		return new ResponseEntity<Users>(userServ.loginUser(newUser),HttpStatus.OK);
	}
	
	@PostMapping("/changepassword")
	public ResponseEntity<Users> changepassword(@Valid @RequestBody Users changepassword) throws InvalidLoginCredentialException{
		Users emp = userServ.changePassword(changepassword);
		ResponseEntity<Users> response = new ResponseEntity<Users>(emp,HttpStatus.OK);
		return response;
	}
	@PatchMapping("/update/forgotpassword/{forgotpassword}")
	public ResponseEntity<Users> forgotpassword(@PathVariable("forgotpassword") String forgotpassword) throws InvalidLoginCredentialException{
		Users user = userServ.forgotPassword(forgotpassword);
		ResponseEntity<Users> response = new ResponseEntity<>(user,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/name/{userName}")
	public ResponseEntity<Users> getUserByUserName(@PathVariable(value = "userName")String userName) throws NoSuchUserException{
		Users user = userServ.searchUserByUserName(userName);
		ResponseEntity<Users> response = new ResponseEntity<>(user,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/id/{userId}")
	public ResponseEntity<Users> getUserByUserId(@PathVariable int userId) throws NoSuchUserException{
		Users user = userServ.searchUserByUserId(userId);
		ResponseEntity<Users> response = new ResponseEntity<>(user,HttpStatus.OK);
		return response;
	}
	


}

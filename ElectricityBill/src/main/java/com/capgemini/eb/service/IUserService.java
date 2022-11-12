package com.capgemini.eb.service;

import com.capgemini.eb.entity.Users;
import com.capgemini.eb.exceptions.DuplicateUserException;
import com.capgemini.eb.exceptions.InvalidLoginCredentialException;
import com.capgemini.eb.exceptions.NoSuchUserException;

public interface IUserService {
	
	public Users registerUser(Users user) throws DuplicateUserException;
	public Users loginUser(Users user) throws InvalidLoginCredentialException;
	public Users changePassword(Users user) throws InvalidLoginCredentialException;
	public Users forgotPassword(String password) throws InvalidLoginCredentialException;
	public void emailPassword(String password) throws InvalidLoginCredentialException;
	public Users searchUserByUserName(String userName) throws NoSuchUserException;
	public Users searchUserByUserId(int userId) throws NoSuchUserException;
	
}

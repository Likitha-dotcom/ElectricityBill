package com.capgemini.eb.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.eb.entity.Users;
import com.capgemini.eb.exceptions.DuplicateUserException;
import com.capgemini.eb.exceptions.InvalidLoginCredentialException;
import com.capgemini.eb.exceptions.NoSuchUserException;
import com.capgemini.eb.repository.IUserRepository;
@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	IUserRepository userRepo;

	@Override
	public Users registerUser(Users newUser) throws DuplicateUserException {
		//if(null==userRepo.findByUserName(newUser.getUserName()))
			return userRepo.save(newUser);
		//throw new DuplicateUserException("This user is already registered");
		
	}

	@Override
	public Users loginUser(Users newUser) throws InvalidLoginCredentialException {
		Users tempUser = userRepo.findByUserName(newUser.getUserName());
		if(null!=tempUser) {
			if(newUser.equals(tempUser)){
				boolean isLoggedIn = true;
				return tempUser;
			}
		}
		
		throw new InvalidLoginCredentialException("Enter valid credentials");
	}

	@Override
	public Users changePassword(Users user) throws InvalidLoginCredentialException {
		if(userRepo.existsById(user.getUserId())) {
			return userRepo.save(user);
		}
		throw new InvalidLoginCredentialException("Invalid credential");
	}

	@Override
	public Users forgotPassword(String password) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void emailPassword(String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Users searchUserByUserName(String userName) throws NoSuchUserException {
		Users tempUser = userRepo.findByUserName(userName);
		if(tempUser.getUserName().equals(userName)) {
			return tempUser;
		}
		throw new NoSuchUserException(userName+ "this user not found");
	}

	@Override
	public Users searchUserByUserId(int userId)throws NoSuchUserException {
		Optional<Users> opt = userRepo.findById(userId);
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new NoSuchUserException("User not found with ID :" + userId);
	}
}

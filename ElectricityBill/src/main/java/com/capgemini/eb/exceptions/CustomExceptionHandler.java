package com.capgemini.eb.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.capgemini.eb.entity.ErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {
	
	// To handle customer Duplicate customer exception
	@ExceptionHandler(DuplicateCustomerException.class)
	public ResponseEntity<ErrorResponse> handleException(DuplicateCustomerException exception) {
		
		//create ErrorResponse obj
		ErrorResponse error = new ErrorResponse();
		
		//update ErrorResponse obj values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
		
		//return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	// To handle No such customer exceptions
	@ExceptionHandler(NoSuchCustomerException.class)
	public ResponseEntity<ErrorResponse> handleException(NoSuchCustomerException exception) {
			
		//create ErrorResponse obj
		ErrorResponse error = new ErrorResponse();
			
		//update ErrorResponse obj values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time
			
		//return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);  //404 Not found
	}
	
	//handles duplicate user
	@ExceptionHandler(DuplicateUserException.class)
	public ResponseEntity<ErrorResponse> handleException(DuplicateUserException exception){
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	//handles invalid login credentials
	@ExceptionHandler(InvalidLoginCredentialException.class)
	public ResponseEntity<ErrorResponse> handleException(InvalidLoginCredentialException exception){
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		
	}
	
	//handles no such user exception
	@ExceptionHandler(NoSuchUserException.class)
	public ResponseEntity<ErrorResponse> handleException(NoSuchUserException exception){
		ErrorResponse error = new ErrorResponse();
		
		// update error obj with values
		error.setStatus(HttpStatus.NOT_FOUND.value()); // 404 not found
		error.setMessage(exception.getMessage()); //get message from exception
		error.setTimeStamp(LocalDateTime.now()); // system time

		// return responseEntity obj
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

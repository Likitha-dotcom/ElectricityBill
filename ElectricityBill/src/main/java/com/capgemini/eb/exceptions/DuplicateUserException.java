package com.capgemini.eb.exceptions;

public class DuplicateUserException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateUserException(String msg) {
		super(msg);
		
	}

}

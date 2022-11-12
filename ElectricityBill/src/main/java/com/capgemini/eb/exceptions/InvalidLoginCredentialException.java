package com.capgemini.eb.exceptions;

public class InvalidLoginCredentialException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidLoginCredentialException(String msg) {
		super(msg);
	}

}

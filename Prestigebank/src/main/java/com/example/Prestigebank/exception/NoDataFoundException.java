package com.example.Prestigebank.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class NoDataFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	public NoDataFoundException(String message) {
		super();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "NoDataFoundException [message=" + message + "]";
	}

	
}

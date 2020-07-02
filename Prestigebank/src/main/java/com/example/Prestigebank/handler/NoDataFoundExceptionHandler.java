package com.example.Prestigebank.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Prestigebank.exception.NoDataFoundException;

@RestControllerAdvice
public class NoDataFoundExceptionHandler {

	@ExceptionHandler
	public String handleNoDataFoundException(NoDataFoundException d)
	{
		return d.getMessage();
	}
}

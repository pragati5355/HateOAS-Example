package com.hateoas.business.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private final Integer errorCode;

	public CustomException(String message, Throwable e, HttpStatus errorCode) {
		super(message, e);
		this.errorCode = errorCode.value();
	}

	public CustomException(String message, HttpStatus errorCode) {
		super(message);
		this.errorCode = errorCode.value();
	}


	
}

package com.raouf.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public abstract class APIBaseException extends RuntimeException{
	public APIBaseException(String message) {
		super(message);
	}
	public abstract HttpStatus getStatus();
}

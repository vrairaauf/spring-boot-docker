package com.raouf.demo;

import org.springframework.http.HttpStatus;

public class NotFoundException extends APIBaseException{
	public NotFoundException(String message) {
		super(message);
	}
	
	public HttpStatus getStatus() {
		return HttpStatus.NOT_FOUND;
	}
}

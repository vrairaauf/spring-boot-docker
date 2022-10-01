package com.raouf.demo;

import org.springframework.http.HttpStatus;

public class ConflicException extends APIBaseException{

	public ConflicException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public HttpStatus getStatus() {
		// TODO Auto-generated method stub
		return HttpStatus.CONFLICT;
	}

}

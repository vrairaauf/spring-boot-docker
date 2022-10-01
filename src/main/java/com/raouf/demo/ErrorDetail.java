package com.raouf.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetail {
	private String message;
	private String uri;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public ErrorDetail() {
		this.timestamp=new Date();
	}
	public ErrorDetail(String message, String uri) {
		super();
		this.message = message;
		this.uri = uri;
	}
	
	
	
}

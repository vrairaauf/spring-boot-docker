package com.raouf.demo;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.List;

@ControllerAdvice
public class APIException extends ResponseEntityExceptionHandler{
	@ExceptionHandler(APIBaseException.class)
	public ResponseEntity<ErrorDetail> handlerException(APIBaseException ex, WebRequest req){
		ErrorDetail error = new ErrorDetail(ex.getMessage(), req.getDescription(false));
		return new ResponseEntity<ErrorDetail>(error, ex.getStatus());
	}
	
	@Override
	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		
		ValidationDetail validation=new ValidationDetail();
		validation.setUri(request.getDescription(false));
		
		List<FieldError> fieldsError=(List<FieldError>) ex.getBindingResult().getFieldError();
		for(FieldError f:fieldsError) {
			validation.addError(f.getDefaultMessage());
		}
		return new ResponseEntity<>(validation, HttpStatus.BAD_REQUEST);
	}
	
}

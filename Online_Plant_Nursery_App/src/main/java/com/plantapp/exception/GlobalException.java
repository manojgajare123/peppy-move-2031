package com.plantapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> customerExceptionHandler(CustomerException ce) {
		return new ResponseEntity<String>(ce.getMessage(), HttpStatus.BAD_REQUEST);
	}
}

package com.plantapp.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.plantapp.model.MyErrorDetails;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(PlantExeption.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(PlantExeption ie, WebRequest req) {

		MyErrorDetails m = new MyErrorDetails();
		m.setLocalDateTime(LocalDateTime.now());
		m.setMessage(ie.getMessage());
		m.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(m, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(PlanterException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(PlanterException ie, WebRequest req) {

		MyErrorDetails m = new MyErrorDetails();
		m.setLocalDateTime(LocalDateTime.now());
		m.setMessage(ie.getMessage());
		m.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(m, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<String> customerExceptionHandler(CustomerException ce) {
		return new ResponseEntity<String>(ce.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> loginExceptionHandler(LoginException se, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(OrderException.class)
	public ResponseEntity<MyErrorDetails> orderExceptionHandler(OrderException se, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails();
		err.setLocalDateTime(LocalDateTime.now());
		err.setMessage(se.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(SeedException.class)
	public ResponseEntity<MyErrorDetails> myExceptionHandler(SeedException ie, WebRequest req) {

		MyErrorDetails m = new MyErrorDetails();
		m.setLocalDateTime(LocalDateTime.now());
		m.setMessage(ie.getMessage());
		m.setDetails(req.getDescription(false));

		return new ResponseEntity<MyErrorDetails>(m, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> myExceptionHandler(Exception ie) {

		return new ResponseEntity<String>(ie.getMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> mynotFoundHandler(NoHandlerFoundException nfe, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), nfe.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMANVExceptionHandler(MethodArgumentNotValidException me) {
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), "Validation Error",
				me.getBindingResult().getFieldError().getDefaultMessage());
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

}

package com.exceptionsHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(NegativeIdException.class)
	public ResponseEntity<String> handlerException(NegativeIdException e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

	}
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity <String> handlerException(EmployeeNotFoundException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		
	}

}

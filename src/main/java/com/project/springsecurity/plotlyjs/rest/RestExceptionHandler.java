package com.project.springsecurity.plotlyjs.rest;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // global exception handling
public class RestExceptionHandler {

	@ExceptionHandler	// Type of response body
	public ResponseEntity<ErrorResponse> handleException (NotFoundException exc){
		
		ErrorResponse error = new ErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}
	
	// Catching ANY exception
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException (FileNotFoundException exc){
	
				ErrorResponse error = new ErrorResponse();
				
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage(exc.getMessage());
				error.setTimeStamp(System.currentTimeMillis());
				
				//return ResponseEntity
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}

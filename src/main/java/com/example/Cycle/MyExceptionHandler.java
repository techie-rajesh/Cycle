package com.example.Cycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> sms(CustomException ce){
		
		return new ResponseEntity<Object>(ce.getMessage(), HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
	}

}

package com.crud_op.globalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

	@ExceptionHandler(Id_NotFound_Exception.class) 
	public ResponseEntity<String> employeeNotFound(Id_NotFound_Exception e){ 
		return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND); 
	}
	
	
	
}
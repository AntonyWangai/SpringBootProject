package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Controller_Advice {

	@ExceptionHandler
	public ResponseEntity<ErrorResponse> getHandler(Exception e){
		ErrorResponse error=new ErrorResponse();
		error.setCurrentTime(System.currentTimeMillis());
		error.setMessage(e.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

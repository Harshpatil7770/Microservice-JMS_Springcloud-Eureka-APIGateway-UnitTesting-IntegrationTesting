package com.xoriant.ecart.globalexceptionhandeler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandeler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InputUserException.class)
	public ResponseEntity<String> inputExceptionHandeler(InputUserException exception) {
		return new ResponseEntity<String>("Please check input !", HttpStatus.BAD_REQUEST);

	}

}

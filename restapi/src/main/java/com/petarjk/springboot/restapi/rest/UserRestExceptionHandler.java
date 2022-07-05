package com.petarjk.springboot.restapi.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandler {

	private final String BAD_REQUEST_EXCEPTION_MESSAGE = "Client error. Invalid request.";

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {

		UserErrorResponse error = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(),
				(System.currentTimeMillis()));

		return new ResponseEntity<UserErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<UserErrorResponse> handleException(Exception exc) {

		UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), BAD_REQUEST_EXCEPTION_MESSAGE,
				System.currentTimeMillis());

		return new ResponseEntity<UserErrorResponse>(error, HttpStatus.BAD_REQUEST);

	}

}

package com.payment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.payment.dto.JsonResponse;

@RestControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(ExceptionRest.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<JsonResponse> handleCustomException(ExceptionRest e) {
	      return new ResponseEntity<JsonResponse>(new JsonResponse(e.getCode(), e.getMessage()), HttpStatus.NOT_FOUND);   
	}
	
}

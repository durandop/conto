package com.payment.exception;

import org.springframework.http.HttpStatus;

public class ExceptionRest extends RuntimeException  {
	   private static final long serialVersionUID = 1L;
	   private String code;
	   private String message;
	   private HttpStatus status;
	   
	public ExceptionRest(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ExceptionRest(String code, String message, HttpStatus status) {
		super();
		this.code = code;
		this.message = message;
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}  
	   
}
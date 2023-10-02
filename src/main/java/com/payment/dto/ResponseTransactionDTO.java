package com.payment.dto;

import java.util.List;

public class ResponseTransactionDTO {
	
	private String status;
	private List<ErrorDTO> errors;
    private ListTransactionDTO payload;
	
	public ResponseTransactionDTO() {
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ErrorDTO> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDTO> errors) {
		this.errors = errors;
	}

	public ListTransactionDTO getPayload() {
		return payload;
	}

	public void setPayload(ListTransactionDTO payload) {
		this.payload = payload;
	}
	
}

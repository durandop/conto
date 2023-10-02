package com.payment.dto;

import java.util.List;

public class ResponseSaldoDTO {
	
	private String status;
	private List<ErrorDTO> errors;
    private SaldoDTO payload;
	
	public ResponseSaldoDTO() {
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

	public SaldoDTO getPayload() {
		return payload;
	}

	public void setPayload(SaldoDTO payload) {
		this.payload = payload;
	}
	

}

package com.payment.dto;

import java.util.List;

public class ResponseTransferDTO {
	
	private String status;
	private List<ErrorDTO> errors;
    private TransferDTO payload;
	
	public ResponseTransferDTO() {
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

	public TransferDTO getPayload() {
		return payload;
	}

	public void setPayload(TransferDTO payload) {
		this.payload = payload;
	}
	
}

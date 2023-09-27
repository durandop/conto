package com.payment.dto;

public class AccountDTO {
	
	private String accountCode;
	private String bicCode;
    
	public AccountDTO() {
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getBicCode() {
		return bicCode;
	}

	public void setBicCode(String bicCode) {
		this.bicCode = bicCode;
	}

}

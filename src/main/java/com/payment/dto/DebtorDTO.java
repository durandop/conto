package com.payment.dto;

public class DebtorDTO {
	
	private String name;
	private AccountDTO account;
	
	public DebtorDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccountDTO getAccount() {
		return account;
	}

	public void setAccount(AccountDTO account) {
		this.account = account;
	}

}

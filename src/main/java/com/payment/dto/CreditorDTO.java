package com.payment.dto;

public class CreditorDTO {
	
	private String name;
	private AccountDTO account = new AccountDTO();
	private AddressDTO address = new AddressDTO();
	
	public CreditorDTO() {
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

	public AddressDTO getAddress() {
		return address;
	}

	public void setAddress(AddressDTO address) {
		this.address = address;
	}

}

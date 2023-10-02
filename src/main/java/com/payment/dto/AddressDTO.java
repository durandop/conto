package com.payment.dto;

public class AddressDTO {
	
	private String address;
	private String city;
	private String countryCode;
	
	public AddressDTO() {
	}

	public Object getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

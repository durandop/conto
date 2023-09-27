package com.payment.dto;

import java.io.Serializable;

public class RequestDTO implements Serializable {
	
	private CreditorDTO creditor = new CreditorDTO();
	private String executionDate;
	private String uri;
	private String description;
	private int amount;
	private String currency;
	private boolean isUrgent;
	private boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private TaxReliefDTO taxRelief = new TaxReliefDTO();
	
	public RequestDTO() {
	}

	public CreditorDTO getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorDTO creditor) {
		this.creditor = creditor;
	}

	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public boolean isUrgent() {
		return isUrgent;
	}

	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public boolean isInstant() {
		return isInstant;
	}

	public void setInstant(boolean isInstant) {
		this.isInstant = isInstant;
	}

	public String getFeeType() {
		return feeType;
	}

	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}

	public String getFeeAccountId() {
		return feeAccountId;
	}

	public void setFeeAccountId(String feeAccountId) {
		this.feeAccountId = feeAccountId;
	}

	public TaxReliefDTO getTaxRelief() {
		return taxRelief;
	}

	public void setTaxRelief(TaxReliefDTO taxRelief) {
		this.taxRelief = taxRelief;
	}

}


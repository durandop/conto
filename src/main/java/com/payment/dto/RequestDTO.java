package com.payment.dto;

import java.io.Serializable;
import java.util.Date;

public class RequestDTO implements Serializable {
	
	private CreditorDTO creditor;
	private Date executionDate;
	private String uri;
	private String description;
	private Integer amount;
	private String currency;
	private Boolean isUrgent;
	private Boolean isInstant;
	private String feeType;
	private String feeAccountId;
	private TaxReliefDTO taxRelief;
	
	public RequestDTO() {
	}

	public CreditorDTO getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorDTO creditor) {
		this.creditor = creditor;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Boolean getIsUrgent() {
		return isUrgent;
	}

	public void setIsUrgent(Boolean isUrgent) {
		this.isUrgent = isUrgent;
	}

	public Boolean getIsInstant() {
		return isInstant;
	}

	public void setIsInstant(Boolean isInstant) {
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


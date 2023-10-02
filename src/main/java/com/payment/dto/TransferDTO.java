package com.payment.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class TransferDTO implements Serializable {
	
	private String moneyTransferId;
	private String status;
	private String direction;
	private CreditorDTO creditor;
	private DebtorDTO debtor;
	private String cro;
	private String uri;
	private String trn;
	private String description;
	private Date createdDatetime;
	private Date accountedDatetime;
	private Date debtorValueDate;
    private Date creditorValueDate;
    private AmountDTO amount;
    private Boolean isUrgent;
    private Boolean isInstant;
    private String feeType;
    private String feeAccountId;
    private ArrayList<FeeDTO> fees;
    private Boolean hasTaxRelief;
	
	public TransferDTO() {
	}

	public String getMoneyTransferId() {
		return moneyTransferId;
	}

	public void setMoneyTransferId(String moneyTransferId) {
		this.moneyTransferId = moneyTransferId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public CreditorDTO getCreditor() {
		return creditor;
	}

	public void setCreditor(CreditorDTO creditor) {
		this.creditor = creditor;
	}

	public DebtorDTO getDebtor() {
		return debtor;
	}

	public void setDebtor(DebtorDTO debtor) {
		this.debtor = debtor;
	}

	public String getCro() {
		return cro;
	}

	public void setCro(String cro) {
		this.cro = cro;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTrn() {
		return trn;
	}

	public void setTrn(String trn) {
		this.trn = trn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDatetime() {
		return createdDatetime;
	}

	public void setCreatedDatetime(Date createdDatetime) {
		this.createdDatetime = createdDatetime;
	}

	public Date getAccountedDatetime() {
		return accountedDatetime;
	}

	public void setAccountedDatetime(Date accountedDatetime) {
		this.accountedDatetime = accountedDatetime;
	}

	public Date getDebtorValueDate() {
		return debtorValueDate;
	}

	public void setDebtorValueDate(Date debtorValueDate) {
		this.debtorValueDate = debtorValueDate;
	}

	public Date getCreditorValueDate() {
		return creditorValueDate;
	}

	public void setCreditorValueDate(Date creditorValueDate) {
		this.creditorValueDate = creditorValueDate;
	}

	public AmountDTO getAmount() {
		return amount;
	}

	public void setAmount(AmountDTO amount) {
		this.amount = amount;
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

	public ArrayList<FeeDTO> getFees() {
		return fees;
	}

	public void setFees(ArrayList<FeeDTO> fees) {
		this.fees = fees;
	}

	public Boolean getHasTaxRelief() {
		return hasTaxRelief;
	}

	public void setHasTaxRelief(Boolean hasTaxRelief) {
		this.hasTaxRelief = hasTaxRelief;
	}

}


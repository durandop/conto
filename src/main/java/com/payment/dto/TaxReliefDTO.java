package com.payment.dto;

public class TaxReliefDTO {
	
	private String taxReliefId;
	private Boolean isCondoUpgrade;
	private String creditorFiscalCode;
	private String beneficiaryType;
	private NaturalPersonBeneficiaryDTO naturalPersonBeneficiary;
	private LegalPersonBeneficiaryDTO legalPersonBeneficiary;
    
	public TaxReliefDTO() {
	}

	public String getTaxReliefId() {
		return taxReliefId;
	}

	public void setTaxReliefId(String taxReliefId) {
		this.taxReliefId = taxReliefId;
	}

	public Boolean isCondoUpgrade() {
		return isCondoUpgrade;
	}

	public void setCondoUpgrade(Boolean isCondoUpgrade) {
		this.isCondoUpgrade = isCondoUpgrade;
	}

	public String getCreditorFiscalCode() {
		return creditorFiscalCode;
	}

	public void setCreditorFiscalCode(String creditorFiscalCode) {
		this.creditorFiscalCode = creditorFiscalCode;
	}

	public String getBeneficiaryType() {
		return beneficiaryType;
	}

	public void setBeneficiaryType(String beneficiaryType) {
		this.beneficiaryType = beneficiaryType;
	}

	public NaturalPersonBeneficiaryDTO getNaturalPersonBeneficiary() {
		return naturalPersonBeneficiary;
	}

	public void setNaturalPersonBeneficiary(NaturalPersonBeneficiaryDTO naturalPersonBeneficiary) {
		this.naturalPersonBeneficiary = naturalPersonBeneficiary;
	}

	public LegalPersonBeneficiaryDTO getLegalPersonBeneficiary() {
		return legalPersonBeneficiary;
	}

	public void setLegalPersonBeneficiary(LegalPersonBeneficiaryDTO legalPersonBeneficiary) {
		this.legalPersonBeneficiary = legalPersonBeneficiary;
	}

}

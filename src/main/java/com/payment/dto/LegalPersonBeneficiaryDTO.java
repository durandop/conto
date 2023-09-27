package com.payment.dto;

public class LegalPersonBeneficiaryDTO {
	
	private String fiscalCode;
	private String legalRepresentativeFiscalCode;
    
	public LegalPersonBeneficiaryDTO() {
	}

	public String getFiscalCode() {
		return fiscalCode;
	}

	public void setFiscalCode(String fiscalCode) {
		this.fiscalCode = fiscalCode;
	}

	public String getLegalRepresentativeFiscalCode() {
		return legalRepresentativeFiscalCode;
	}

	public void setLegalRepresentativeFiscalCode(String legalRepresentativeFiscalCode) {
		this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode;
	}

}

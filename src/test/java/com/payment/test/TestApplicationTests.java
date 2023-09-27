package com.payment.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.payment.dto.AccountDTO;
import com.payment.dto.CreditorDTO;
import com.payment.dto.LegalPersonBeneficiaryDTO;
import com.payment.dto.ListTransactionDTO;
import com.payment.dto.NaturalPersonBeneficiaryDTO;
import com.payment.dto.RequestDTO;
import com.payment.dto.SaldoDTO;
import com.payment.dto.TaxReliefDTO;
import com.payment.dto.TransferDTO;
import com.payment.exception.ExceptionRest;
import com.payment.service.ContoService;

@SpringBootTest
class TestApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
    private ContoService contoService;
 
    @Test
    public void testLetturaSaldo() {
    	String accountId = "14537780";
    	SaldoDTO saldo = contoService.letturaSaldo(accountId);
        Assert.assertTrue(saldo!=null && saldo.getAccountId()!=null && saldo.getAccountId().equals(accountId.toString()));
    }
    
    @Test
    public void testBonificoError() throws ExceptionRest {
    	String accountId = "14537780";
    	RequestDTO request = new RequestDTO();
    	CreditorDTO creditor = new CreditorDTO();
    	creditor.setName("John Doe");
    	AccountDTO account = new AccountDTO();
    	account.setAccountCode("IT23A0336844430152923804660");
    	account.setBicCode("SELBIT2BXXX");
    	creditor.setAccount(account);
    	request.setCreditor(creditor);
    	request.setExecutionDate("2019-04-01");
    	request.setUri("REMITTANCE_INFORMATION");
    	request.setDescription("Payment invoice 75/2017");
    	request.setAmount(800);
    	request.setCurrency("EUR");
    	request.setFeeType("SHA");
    	request.setFeeAccountId("45685475");
    	
    	TaxReliefDTO tax = new TaxReliefDTO();
    	tax.setTaxReliefId("L449");
    	tax.setCondoUpgrade(false);
    	tax.setCreditorFiscalCode("56258745832");
    	tax.setBeneficiaryType("NATURAL_PERSON");
    	NaturalPersonBeneficiaryDTO natural = new NaturalPersonBeneficiaryDTO();
    	natural.setFiscalCode1("MRLFNC81L04A859L");
    	tax.setNaturalPersonBeneficiary(natural);
    	LegalPersonBeneficiaryDTO legal = new LegalPersonBeneficiaryDTO();
    	tax.setLegalPersonBeneficiary(legal);
    	request.setTaxRelief(tax);
    	
    	TransferDTO transfer = contoService.bonifico(accountId, request);
        Assert.assertTrue(transfer!=null && transfer.getError()!=null && (transfer.getError().getCode().equals("API000") || transfer.getError().getCode().equals("REQ010")));
    }
    
    @Test
    public void testLetturaTransazioni() throws ParseException {
    	String accountId = "14537780";
    	
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    	String fromS = "1-Jan-2019";
    	Date fromAccountingDate = formatter.parse(fromS);
    	String toS = "1-Dec-2019";
    	Date toAccountingDate = formatter.parse(toS);
    	
    	ListTransactionDTO transazioni = contoService.letturaTransazioni(accountId, fromAccountingDate, toAccountingDate);
        Assert.assertTrue(transazioni!=null && transazioni.getList()!=null &&transazioni.getList().size()>0);
    }

}

package com.payment.service;

import java.util.Date;

import com.payment.dto.ListTransactionDTO;
import com.payment.dto.RequestDTO;
import com.payment.dto.SaldoDTO;
import com.payment.dto.TransferDTO;

public interface ContoService {
	
	
	SaldoDTO letturaSaldo(String accountId);
	
	TransferDTO bonifico(String accountId, RequestDTO request);
	
	ListTransactionDTO letturaTransazioni(String accountId, Date fromAccountingDate, Date toAccountingDate);

}

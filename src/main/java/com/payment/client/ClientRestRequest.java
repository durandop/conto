package com.payment.client;



import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseSaldoDTO;
import com.payment.dto.ResponseTransactionDTO;
import com.payment.dto.ResponseTransferDTO;

public interface ClientRestRequest {
	ResponseSaldoDTO getRestSaldo(String url, String accountId);
	ResponseTransactionDTO getRestTransazioni(String url, String accountId);
	ResponseTransferDTO postRestBonifico(String url, String accountId, RequestDTO body);
}

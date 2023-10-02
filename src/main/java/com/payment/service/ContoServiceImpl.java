package com.payment.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import com.payment.client.ClientRestRequest;
import com.payment.constants.Constants;
import com.payment.dto.ListTransactionDTO;
import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseSaldoDTO;
import com.payment.dto.ResponseTransactionDTO;
import com.payment.dto.ResponseTransferDTO;
import com.payment.dto.SaldoDTO;
import com.payment.dto.TransferDTO;
import com.payment.exception.ExceptionRest;


public class ContoServiceImpl implements ContoService {
	
	private static final Logger logger = Logger.getLogger(ContoServiceImpl.class.getName());
	
	@Autowired
	private ClientRestRequest restRequest;

	@Override
	public SaldoDTO letturaSaldo(String accountId) {
		SaldoDTO saldo = null;
		try {
			String api = Constants.API_SALDO;
			ResponseSaldoDTO respSaldo = restRequest.getRestSaldo(Constants.BASE_URL+api, accountId);
			saldo = respSaldo.getPayload();
		} catch (ExceptionRest e) {
			logger.log(Level.SEVERE, "ExceptionRest", e);
			throw e;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new ExceptionRest(Constants.ERROR_GENERIC_CODE, Constants.ERROR_GENERIC_DESCRIPTION);
		}
		return saldo;
	}

	@Override
	public TransferDTO bonifico(String accountId, RequestDTO request) {
		TransferDTO transfer = null;
		try {
			String api = Constants.API_BONIFICO;
			ResponseTransferDTO respTran = restRequest.postRestBonifico(Constants.BASE_URL+api, accountId, request);
			transfer = respTran.getPayload();
		} catch (ExceptionRest e) {
			logger.log(Level.SEVERE, "ExceptionRest", e);
			throw e;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new ExceptionRest(Constants.ERROR_GENERIC_CODE, Constants.ERROR_GENERIC_DESCRIPTION);
		}
		return transfer;
	}

	@Override
	public ListTransactionDTO letturaTransazioni(String accountId, Date fromAccountingDate, Date toAccountingDate) {
		ListTransactionDTO transactions = null;
		try {
			StringBuilder api = new StringBuilder(Constants.BASE_URL);
			api.append(Constants.API_TRANSAZIONI);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			String from = dateFormat.format(fromAccountingDate);
			String to = dateFormat.format(toAccountingDate);
			api.append(Constants.FROM_ACCOUNTING_DATE+"="+from);
			api.append("&"+Constants.TO_ACCOUNTING_DATE+"="+to);
			
			ResponseTransactionDTO respTRan = restRequest.getRestTransazioni(api.toString(), accountId);
			transactions = respTRan.getPayload();
			
		} catch (ExceptionRest e) {
			logger.log(Level.SEVERE, "ExceptionRest", e);
			throw e;
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new ExceptionRest(Constants.ERROR_GENERIC_CODE, Constants.ERROR_GENERIC_DESCRIPTION);
		}
		return transactions;
	}

}

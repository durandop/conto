package com.payment.client;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.payment.constants.Constants;
import com.payment.dto.RequestDTO;
import com.payment.dto.ResponseSaldoDTO;
import com.payment.dto.ResponseTransactionDTO;
import com.payment.dto.ResponseTransferDTO;
import com.payment.exception.ExceptionRest;

public class ClientRestRequestImpl implements ClientRestRequest {

	private static final Logger logger = Logger.getLogger(ClientRestRequest.class.getName());
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ResponseSaldoDTO getRestSaldo(String url, String accountId) {
		ResponseSaldoDTO response = null;
		ResponseEntity<ResponseSaldoDTO> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(Constants.AUTH_SCHEMA_DESCR, Constants.AUTH_SCHEMA);
			headers.set(Constants.API_KEY_DESCR, Constants.API_KEY);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity request = new HttpEntity(headers);
			
			responseEntity = restTemplate.exchange(
			        url,
			        HttpMethod.GET,
			        request,
			        ResponseSaldoDTO.class,
			        accountId
			);
			
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				logger.log(Level.INFO, "Request Successful: "+responseEntity.getBody());
			} 
			response = responseEntity.getBody();
		
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception: "+e);
			throw new ExceptionRest(Constants.ERROR_SERVICE_SALDO_CODE, Constants.ERROR_SERVICE_SALDO_DESCR, HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@Override
	public ResponseTransactionDTO getRestTransazioni(String url, String accountId) {
		ResponseTransactionDTO response = null;
		ResponseEntity<ResponseTransactionDTO> responseEntity = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.set(Constants.AUTH_SCHEMA_DESCR, Constants.AUTH_SCHEMA);
			headers.set(Constants.API_KEY_DESCR, Constants.API_KEY);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity request = new HttpEntity(headers);
			
			responseEntity = restTemplate.exchange(
			        url,
			        HttpMethod.GET,
			        request,
			        ResponseTransactionDTO.class,
			        accountId
			);
			
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				logger.log(Level.INFO, "Request Successful: "+responseEntity.getBody());
			} 
			response = responseEntity.getBody();
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception: "+e);
			throw new ExceptionRest(Constants.ERROR_SERVICE_TRANSACTIONS_CODE, Constants.ERROR_SERVICE_TRANSACTIONS_DESCR, HttpStatus.BAD_REQUEST);

		}
		return response;
	}

	@Override
	public ResponseTransferDTO postRestBonifico(String url, String accountId, RequestDTO body) {
		ResponseTransferDTO response = null;
		ResponseEntity<ResponseTransferDTO> responseEntity = null;
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(Constants.AUTH_SCHEMA_DESCR, Constants.AUTH_SCHEMA);
			headers.set(Constants.API_KEY_DESCR, Constants.API_KEY);
			headers.set(Constants.TIME_ZONE_DESCR, Constants.TIME_ZONE);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			// build the request
			HttpEntity<RequestDTO> request = new HttpEntity<>(body, headers);
			
			responseEntity = restTemplate.postForEntity(url, request, ResponseTransferDTO.class);
			
			if (responseEntity.getStatusCode() == HttpStatus.OK) {
				logger.log(Level.INFO, "Request Successful: "+responseEntity.getBody());
			} 
			response = responseEntity.getBody();
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception: "+e);
			throw new ExceptionRest(Constants.ERROR_BONIFICO_CODE, Constants.ERROR_BONIFICO_DESCRIPTION);
		}
		return response;
	}
	
}

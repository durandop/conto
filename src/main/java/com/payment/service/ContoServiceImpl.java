package com.payment.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.payment.client.ClientRestRequest;
import com.payment.constants.Constants;
import com.payment.dto.ErrorDTO;
import com.payment.dto.ListTransactionDTO;
import com.payment.dto.RequestDTO;
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
			api = api.replace("{accountId}", accountId);
			JSONObject response = restRequest.getRestResponse(Constants.BASE_URL+api);
			ObjectMapper objectMapper = new ObjectMapper();
			if (response != null) {
				try {
					try {
						String status = response.getString("status");
						logger.info("letturaSaldo status: " + status);
						if(status!=null && status.equals("OK")) {
							saldo = objectMapper.readValue(response.getString("payload"), SaldoDTO.class);
						}
						else {
							logger.log(Level.SEVERE, "Error service - KO");
							throw new Exception();
						}
					} catch (JSONException e) {
						 logger.log(Level.SEVERE, "JSONException", e);
						 throw e;
					}
				} catch (JsonParseException e) {
					logger.log(Level.SEVERE, "JsonParseException", e);
					throw e;
				} catch (JsonMappingException e) {
					logger.log(Level.SEVERE, "JsonMappingException", e);
					throw e;
				} catch (IOException e) {
					logger.log(Level.SEVERE, "IOException", e);
					throw e;
				} 
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
		}
		return saldo;
	}

	@Override
	public TransferDTO bonifico(String accountId, RequestDTO request) {
		TransferDTO transfer = null;
		try {
			String api = Constants.API_BONIFICO;
			api = api.replace("{accountId}", accountId);
			JSONObject response = restRequest.postRestResponse(Constants.BASE_URL+api, request);
			ObjectMapper objectMapper = new ObjectMapper();
			if (response != null) {
				try {
					try {
						String status = response.getString("status");
						logger.info("bonifico status: " + status);
						if(status!=null && status.equals("OK")) {
							transfer = objectMapper.readValue(response.getString("payload"), TransferDTO.class);
						}
						else {
							logger.log(Level.SEVERE, "Error service - KO");
							List<ErrorDTO> listError = objectMapper.readValue(response.getString("errors"), new TypeReference<List<ErrorDTO>>(){});
							if(listError.size()>0) {
								transfer = new TransferDTO();
								transfer.setError(listError.get(0));
							}
						}
					} catch (JSONException e) {
						 logger.log(Level.SEVERE, "JSONException", e);
						 throw e;
					}
				} catch (JsonParseException e) {
					logger.log(Level.SEVERE, "JsonParseException", e);
					throw e;
				} catch (JsonMappingException e) {
					logger.log(Level.SEVERE, "JsonMappingException", e);
					throw e;
				} catch (IOException e) {
					logger.log(Level.SEVERE, "IOException", e);
					throw e;
				} 
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
			throw new ExceptionRest(Constants.ERROR_BONIFICO_CODE, Constants.ERROR_BONIFICO_DESCRIPTION);
		}
		return transfer;
	}

	@Override
	public ListTransactionDTO letturaTransazioni(String accountId, Date fromAccountingDate, Date toAccountingDate) {
		ListTransactionDTO transactions = null;
		try {
			String api = Constants.API_TRANSAZIONI;
			api = api.replace("{accountId}", accountId);
			String apiParams = Constants.TRANSAZIONI_PARAMS;
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			String from = dateFormat.format(fromAccountingDate);
			apiParams = apiParams.replace("{from}", from);
			String to = dateFormat.format(toAccountingDate);
			apiParams = apiParams.replace("{to}", to);
			
			JSONObject response = restRequest.getRestResponse(Constants.BASE_URL+api+apiParams);
			ObjectMapper objectMapper = new ObjectMapper();
			if (response != null) {
				try {
					try {
						String status = response.getString("status");
						logger.info("letturaTransazioni status: " + status);
						if(status!=null && status.equals("OK")) {
							transactions = objectMapper.readValue(response.getString("payload"), ListTransactionDTO.class);
						}
						else {
							logger.log(Level.SEVERE, "Error service - KO");
							throw new Exception();
						}
					} catch (JSONException e) {
						 logger.log(Level.SEVERE, "JSONException", e);
						 throw e;
					}
				} catch (JsonParseException e) {
					logger.log(Level.SEVERE, "JsonParseException", e);
					throw e;
				} catch (JsonMappingException e) {
					logger.log(Level.SEVERE, "JsonMappingException", e);
					throw e;
				} catch (IOException e) {
					logger.log(Level.SEVERE, "IOException", e);
					throw e;
				} 
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception", e);
		}
		return transactions;
	}

}

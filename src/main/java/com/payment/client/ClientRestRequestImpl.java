package com.payment.client;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;
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

public class ClientRestRequestImpl implements ClientRestRequest {

	private static final Logger logger = Logger.getLogger(ClientRestRequest.class.getName());
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public JSONObject getRestResponse(String url) {
		JSONObject jsonResponse = null;
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(Constants.AUTH_SCHEMA_DESCR, Constants.AUTH_SCHEMA);
			headers.set(Constants.API_KEY_DESCR, Constants.API_KEY);
			HttpEntity request = new HttpEntity(headers);
			
			ResponseEntity<String> response = restTemplate.exchange(
			        url,
			        HttpMethod.GET,
			        request,
			        String.class
			);
			
			if (response.getStatusCode() == HttpStatus.OK) {
				logger.log(Level.INFO, "Request Successful: "+response.getBody());
			} else {
				logger.log(Level.SEVERE, "Request Failed: "+response.getStatusCode());
			}
			
			String result = response.getBody();
			jsonResponse = new JSONObject(result);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception: "+e);
		}
		return jsonResponse;
	}

	@Override
	public JSONObject postRestResponse(String url, RequestDTO body) {
		JSONObject jsonResponse = null;
		try {
			
			HttpHeaders headers = new HttpHeaders();
			headers.set(Constants.AUTH_SCHEMA_DESCR, Constants.AUTH_SCHEMA);
			headers.set(Constants.API_KEY_DESCR, Constants.API_KEY);
			headers.set(Constants.TIME_ZONE_DESCR, Constants.TIME_ZONE);
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			// build the request
			HttpEntity<RequestDTO> request = new HttpEntity<>(body, headers);
			ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
			
			if (response.getStatusCode() == HttpStatus.OK) {
				logger.log(Level.INFO, "Request Successful: "+response.getBody());
			} else {
				logger.log(Level.SEVERE, "Request Failed: "+response.getStatusCode());
			}
			
			String result = response.getBody();
			jsonResponse = new JSONObject(result);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Exception: "+e);
			try {
				String error = e.getMessage();
				error = error.substring(error.indexOf('[')+1, error.lastIndexOf(']'));
				jsonResponse = new JSONObject(error);
			} catch (JSONException e1) {
			}
		}
		return jsonResponse;
	}
	
}

package com.payment.client;



import org.json.JSONObject;

import com.payment.dto.RequestDTO;

public interface ClientRestRequest {
	JSONObject getRestResponse(String url);
	JSONObject postRestResponse(String url, RequestDTO body);
}

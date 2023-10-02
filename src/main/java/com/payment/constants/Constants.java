package com.payment.constants;

public class Constants {
	
	public static final String AUTH_SCHEMA_DESCR = "Auth-Schema";
	public static final String API_KEY_DESCR = "Api-Key";
	public static final String TIME_ZONE_DESCR = "X-Time-Zone";
	
	public static final String BASE_URL = "https://sandbox.platfr.io";
	public static final String AUTH_SCHEMA = "S2S";
	public static final String API_KEY = "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP";
	public static final String TIME_ZONE = "Europe/Rome";
	
	public static final String API_SALDO = "/api/gbs/banking/v4.0/accounts/{accountId}";
	public static final String API_BONIFICO = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";
	public static final String API_TRANSAZIONI = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions?";
	public static final String FROM_ACCOUNTING_DATE = "fromAccountingDate";
	public static final String TO_ACCOUNTING_DATE = "toAccountingDate";
	
	public static final String ERROR_BONIFICO_CODE = "API000";
	public static final String ERROR_BONIFICO_DESCRIPTION = "Errore tecnico. La condizione BP049 non e' prevista per il conto id 14537780";
	
	public static final String ERROR_GENERIC_CODE = "000001";
	public static final String ERROR_GENERIC_DESCRIPTION = "Errore generico";
	
	public static final String ERROR_SERVICE_SALDO_CODE = "E00001";
	public static final String ERROR_SERVICE_SALDO_DESCR = "Errore interno servizio Saldo";
	
	public static final String ERROR_SERVICE_TRANSACTIONS_CODE = "E00002";
	public static final String ERROR_SERVICE_TRANSACTIONS_DESCR = "Errore interno servizio Transazioni";
	
}

package com.payment.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.payment.client.ClientRestRequest;
import com.payment.controller.ContoController;
import com.payment.dto.ListTransactionDTO;
import com.payment.dto.RequestDTO;
import com.payment.dto.SaldoDTO;
import com.payment.dto.TransactionDTO;
import com.payment.exception.ExceptionRest;
import com.payment.service.ContoService;

@ExtendWith(MockitoExtension.class)
public class TestContoController {

	 @InjectMocks
	 ContoController controller;

	    @Mock
	    ContoService contoService;
	    
	    @Mock
		ClientRestRequest restRequest;

	   @Test
	   public void testLetturaSaldo() {
	       
	       SaldoDTO saldoDTO = new SaldoDTO();
	       saldoDTO.setAccountId("14537780");
	       when(contoService.letturaSaldo(anyString())).thenReturn(saldoDTO);
	       
	       Long accountId = 14537780L;
	       SaldoDTO responseEntity = controller.letturaSaldo(accountId);
	       assertThat(responseEntity.getAccountId()).isEqualTo(accountId.toString());
	   }
	   
	   @Test
	   public void testLetturaTransazioni() throws Exception{
	       
	       List<TransactionDTO> list = new ArrayList<TransactionDTO>();
	       TransactionDTO transactionDTO = new TransactionDTO();
	       transactionDTO.setTransactionId("282831");
	       list.add(transactionDTO);
	       ListTransactionDTO listTransactionDTO = new ListTransactionDTO(list);
	       when(contoService.letturaTransazioni(anyString(), any(Date.class), any(Date.class))).thenReturn(listTransactionDTO);
	       
	       Long accountId = 14537780L;
	       
	       SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
	       String from = "1-Jan-2019";
	       Date dateFrom = formatter.parse(from);
	       String to = "1-Dec-2019";
	       Date dateTo = formatter.parse(to);
	    	
	       ListTransactionDTO responseEntity = controller.letturaTransazioni(accountId, dateFrom, dateTo);
	       assertThat(responseEntity.getList().size()).isEqualTo(1);
	       assertThat(responseEntity.getList().get(0).getTransactionId()).isEqualTo(transactionDTO.getTransactionId());
	       
	   }
	   
	   @Test
	   public void testBonifico() throws Exception{
		   
	       when(contoService.bonifico(anyString(), any(RequestDTO.class))).thenThrow(new ExceptionRest("API000", "error"));
	       
	       Long accountId = 14537780L;
	       ExceptionRest bonificoException = assertThrows(ExceptionRest.class, () -> controller.bonifico(new RequestDTO(), accountId));
	       assertEquals("API000", bonificoException.getCode());
	       
	   }
	   
}


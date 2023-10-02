package com.payment.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payment.dto.ListTransactionDTO;
import com.payment.dto.RequestDTO;
import com.payment.dto.SaldoDTO;
import com.payment.dto.TransferDTO;
import com.payment.service.ContoService;

@RestController
@RequestMapping("contorest")
public class ContoController {
	
	@Autowired
    private ContoService contoService;
	
	@RequestMapping(value = "/{accountId}", method = RequestMethod.GET)
    public SaldoDTO letturaSaldo(@PathVariable Long accountId) {
        return contoService.letturaSaldo(accountId.toString());
    }
	
	@RequestMapping(value = "/{accountId}/bonifico", method = RequestMethod.POST)
	public TransferDTO bonifico(@RequestBody RequestDTO request, @PathVariable Long accountId) throws Exception {
	    return contoService.bonifico(accountId.toString(), request);
	}
	
	@RequestMapping(value = "/{accountId}/transactions", method = RequestMethod.GET)
    public ListTransactionDTO letturaTransazioni(@PathVariable Long accountId, @RequestParam("from") @DateTimeFormat(pattern="yyyy-MM-dd") Date from, @RequestParam("to") @DateTimeFormat(pattern="yyyy-MM-dd") Date to) {
        return contoService.letturaTransazioni(accountId.toString(), from, to);
    }

}

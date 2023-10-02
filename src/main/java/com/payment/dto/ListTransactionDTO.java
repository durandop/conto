package com.payment.dto;

import java.util.List;

public class ListTransactionDTO {
	
	private List<TransactionDTO> list;
	
	public ListTransactionDTO() {
	}

	public ListTransactionDTO(List<TransactionDTO> list) {
		super();
		this.list = list;
	}

	public List<TransactionDTO> getList() {
		return list;
	}

	public void setList(List<TransactionDTO> list) {
		this.list = list;
	}

}


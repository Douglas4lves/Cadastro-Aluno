package com.academy.Enum;

public enum Status {

	ATIVO("Ativo"),
	INATIVO("Inativos"),
	TRANCADO("Trancado"),
	CANCELADO("Cancelado");
	
	private String status;
	
	private Status (String status) {
		this.status = status;
	}
}

package com.example.demo.controller.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Agendamento não encontrado!")
public class AgendamentoNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public AgendamentoNotFoundException() {
		super();
	}

	public AgendamentoNotFoundException(String message) {
		super(message);
	}
	
}

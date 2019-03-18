package com.example.demo.controller.dtos;

import java.sql.Date;

public class AgendaRequest {

	private String nome;
	

	private String email;
	

	private Date dataAgendamento;
	

	private Integer telefone;


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getDataAgendamento() {
		return dataAgendamento;
	}


	public void setDataAgendamento(Date dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}


	public Integer getTelefone() {
		return telefone;
	}


	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	
	
}

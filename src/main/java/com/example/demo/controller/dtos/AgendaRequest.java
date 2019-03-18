package com.example.demo.controller.dtos;

import java.sql.Date;

import javax.validation.constraints.NotNull;

import com.example.demo.domain.Agendamento;

public class AgendaRequest {

	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	

	private Date dataAgendamento;
	
	@NotNull
	private Integer telefone;
	
	public Agendamento toEntity(){
        return new Agendamento(nome, email,dataAgendamento, telefone);
    }


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

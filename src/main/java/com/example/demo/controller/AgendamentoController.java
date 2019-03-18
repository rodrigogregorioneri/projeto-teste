package com.example.demo.controller;

import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dtos.AgendaRequest;
import com.example.demo.controller.errors.AgendamentoNotFoundException;
import com.example.demo.domain.Agendamento;
import com.example.demo.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {


	private static final String NOT_FOUND = "Agendamento não encontrado!";
	@Autowired
	private AgendamentoService service;

	@GetMapping("/{id}")
	public Agendamento getOne(@PathVariable UUID id) {
		if(!service.findById(id).isPresent()) {
			throw new AgendamentoNotFoundException(NOT_FOUND);
		}
		return service.findById(id).get();
	}

	@GetMapping()
	public Page<Agendamento> getAll(int page, int size) {
		return service.getAll(page, size);
	}

	@PostMapping()
	public Agendamento create(@RequestBody @Valid Agendamento agendamento) {
		return service.create(agendamento);
	}

	@PutMapping("/{id}")
	public Agendamento update(@PathVariable UUID id, @RequestBody @Valid AgendaRequest agendamento) {
		if(!service.findById(id).isPresent()) {
			throw new AgendamentoNotFoundException(NOT_FOUND);
		}
		Agendamento a = service.getOne(id);
		a.setEmail(agendamento.getEmail());
		a.setNome(agendamento.getNome());
		a.setTelefone(agendamento.getTelefone());
		a.setDataAgendamento(agendamento.getDataAgendamento());

		return service.update(id, agendamento);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		if(!service.findById(id).isPresent()) {
			throw new AgendamentoNotFoundException(NOT_FOUND);
		}
		Agendamento agendamento = service.getOne(id);
		service.delete(agendamento);
	}

}

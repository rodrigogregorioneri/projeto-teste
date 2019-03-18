package com.example.demo.controller;

import java.util.UUID;

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
import com.example.demo.domain.Agendamento;
import com.example.demo.service.AgendamentoService;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

	@Autowired
	private AgendamentoService service;

	@GetMapping("/{id}")
	public Agendamento getOne(@PathVariable UUID id) {
		return service.getOne(id);
	}

	@GetMapping()
	public Page<Agendamento> getAll(int page, int size) {
		return service.getAll(page, size);
	}

	@PostMapping()
	public Agendamento create(@RequestBody Agendamento agendamento) {
		return service.create(agendamento);
	}

	@PutMapping("/{id}")
	public Agendamento update(@PathVariable UUID id, @RequestBody AgendaRequest agendamento) {
		Agendamento a = service.getOne(id);

		a.setEmail(agendamento.getEmail());
		a.setNome(agendamento.getNome());
		a.setTelefone(agendamento.getTelefone());
		a.setDataAgendamento(agendamento.getDataAgendamento());

		return service.update(id, agendamento);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable UUID id) {
		service.delete(id);
	}

}

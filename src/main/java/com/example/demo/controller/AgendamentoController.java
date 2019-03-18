package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Agendamento;
import com.example.demo.repository.AgendamentoRepository;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository repository;
	
	@PostMapping()
    public Agendamento create(@RequestBody Agendamento agendamento){
        return repository.save(agendamento);
    }
	
	@PutMapping()
    public Agendamento update(@RequestBody Agendamento agendamento){
		Agendamento a = repository.getOne(agendamento.getId());
        return repository.save(a);
    }
	
	@DeleteMapping()
    public void delete(@RequestBody Agendamento agendamento){
		Agendamento a = new Agendamento(agendamento.getId());
        repository.delete(a);
    }

}

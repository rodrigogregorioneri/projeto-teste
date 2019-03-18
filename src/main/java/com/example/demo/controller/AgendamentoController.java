package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.dtos.AgendaRequest;
import com.example.demo.domain.Agendamento;
import com.example.demo.repository.AgendamentoRepository;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository repository;
	
	@GetMapping("/{id}") 
	public Agendamento getOne(@PathVariable Integer id){
        return repository.getOne(id);
	}
	
	@GetMapping() 
	public Page<Agendamento>getAll(@RequestParam int page, @RequestParam(defaultValue = "20") int size){
        return repository.findAll(PageRequest.of(page, size));
	}
	
	@PostMapping()
    public Agendamento create(@RequestBody Agendamento agendamento){
        return repository.save(agendamento);
    }
	
	@PutMapping()
    public Agendamento update(Integer id,@RequestBody AgendaRequest agendamento){
		Agendamento a = repository.getOne(id);

	      a.setEmail(agendamento.getEmail());
	      a.setNome(agendamento.getNome());
	      a.setTelefone(agendamento.getTelefone());
	      a.setDataAgendamento(agendamento.getDataAgendamento());
	      
        return repository.save(a);
    }
	
	@DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
		Agendamento a = repository.getOne(id);
        repository.delete(a);
    }

}

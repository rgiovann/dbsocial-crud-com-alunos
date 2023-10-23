package com.portalsocial.portalsocial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.portalsocial.portalsocial.api.dto.ProfessorDto;
import com.portalsocial.portalsocial.api.input.ProfessorNomeInput;
import com.portalsocial.portalsocial.assembler.ProfessorDtoAssembler;
import com.portalsocial.portalsocial.assembler.ProfessorNomeInputDisassembler;
import com.portalsocial.portalsocial.domain.model.Professor;
import com.portalsocial.portalsocial.service.CadastroProfessorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

	private final CadastroProfessorService estadoService;
    private final ProfessorDtoAssembler professorDtoAssembler;
    private final ProfessorNomeInputDisassembler professorNomeInputDisassembler;
	

	public ProfessorController(CadastroProfessorService estadoService, ProfessorDtoAssembler estadoDtoAssembler,
			ProfessorNomeInputDisassembler estadoInputDisassembler) {
		this.estadoService = estadoService;
		this.professorDtoAssembler = estadoDtoAssembler;
		this.professorNomeInputDisassembler = estadoInputDisassembler;
	}

	@GetMapping
	public List<ProfessorDto> listar() {

		return professorDtoAssembler.toCollectionDto(estadoService.listar());
 
	}
	
	@GetMapping("/{estadoId}")
	public ProfessorDto buscar(@PathVariable Long estadoId) {

		return  professorDtoAssembler.toDto(estadoService.buscarOuFalhar(estadoId));

	}


	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProfessorDto adicionar(@RequestBody @Valid ProfessorNomeInput professorNomeInput) {
		
		return  professorDtoAssembler
				.toDto( estadoService.salvar( professorNomeInputDisassembler.toEntity(professorNomeInput)));

	}
	
	@PutMapping("/{estadoId}")
	public ProfessorDto atualizar(@PathVariable Long estadoId, @RequestBody @Valid  ProfessorNomeInput professorNomeInput)
	{        
			Professor estado = estadoService.buscarOuFalhar(estadoId);
			
			professorNomeInputDisassembler.copyToEntity(professorNomeInput,estado);
		 
			return  professorDtoAssembler.toDto( estadoService.salvar(estado));
  
	}

	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {

			estadoService.excluir(estadoId);
	}

}

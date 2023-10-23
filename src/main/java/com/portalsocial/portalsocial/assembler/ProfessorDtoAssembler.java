package com.portalsocial.portalsocial.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portalsocial.portalsocial.api.dto.ProfessorDto;
import com.portalsocial.portalsocial.domain.model.Professor;


@Component
public class ProfessorDtoAssembler extends EntitytDtoAssembler<ProfessorDto, Professor>{

	public ProfessorDtoAssembler(ModelMapper mapper) {
		super(mapper);
	}

}
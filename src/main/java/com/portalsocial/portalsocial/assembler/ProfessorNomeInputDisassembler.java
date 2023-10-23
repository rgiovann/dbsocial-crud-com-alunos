package com.portalsocial.portalsocial.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.portalsocial.portalsocial.api.input.ProfessorNomeInput;
import com.portalsocial.portalsocial.domain.model.Professor;

@Component
public class ProfessorNomeInputDisassembler extends EntityInputDisassembler<ProfessorNomeInput, Professor>{

	public ProfessorNomeInputDisassembler(ModelMapper mapper) {
		super(mapper);
	}
}

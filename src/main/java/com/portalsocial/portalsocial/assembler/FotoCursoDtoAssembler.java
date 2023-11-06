package com.portalsocial.portalsocial.assembler;

import com.portalsocial.portalsocial.api.dto.FotoCursoDto;
import com.portalsocial.portalsocial.domain.model.FotoCurso;
import org.modelmapper.ModelMapper;

public class FotoCursoDtoAssembler extends EntitytDtoAssembler<FotoCursoDto, FotoCurso> {

    public FotoCursoDtoAssembler(ModelMapper mapper){
        super(mapper);
    }
}

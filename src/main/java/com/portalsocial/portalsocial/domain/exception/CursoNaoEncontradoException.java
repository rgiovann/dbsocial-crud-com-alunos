package com.portalsocial.portalsocial.domain.exception;

import java.io.Serial;

public class CursoNaoEncontradoException extends EntidadeNaoEncontradaException{

    @Serial
    private static final long serialVersionUID = 1L;

    public CursoNaoEncontradoException(String msg){
        super(msg);
    }
    public CursoNaoEncontradoException(Long cursoId){
        this(String.format("Curso de código %d não encontrado.",cursoId));

    }
}

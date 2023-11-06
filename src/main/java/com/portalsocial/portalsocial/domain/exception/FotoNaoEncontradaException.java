package com.portalsocial.portalsocial.domain.exception;

import java.io.Serial;

public class FotoNaoEncontradaException extends EntidadeNaoEncontradaException {
    @Serial
    private static final long serialVersionUID = 1L;

    public FotoNaoEncontradaException(String msg){
        super(msg);
    }
    public FotoNaoEncontradaException(Long cursoId){
        this(String.format("Curso de código %d não encontrado.",cursoId));

    }
}

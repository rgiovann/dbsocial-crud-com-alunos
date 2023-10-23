package com.portalsocial.portalsocial.domain.exception;

import java.io.Serial;

public class CategoriaNaoEncontradaException extends EntidadeNaoEncontradaException {

    @Serial
    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException(String msg){
        super(msg);
    }

    public CategoriaNaoEncontradaException(Long cursoId){
        this(String.format("Categoria de curso com id %d não encontrado.",cursoId));
    }
}

package com.portalsocial.portalsocial.domain.exception;

public class ProfessorNaoEncontradoException extends EntidadeNaoEncontradaException {
	
	private static final long serialVersionUID = 1L;

	public ProfessorNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public ProfessorNaoEncontradoException(Long estadoId) {
		// chamando o construtor anterior;
		 this(String.format("Professor de código %d não encontrado.",estadoId));
	}


}

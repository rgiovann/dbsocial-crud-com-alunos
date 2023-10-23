package com.portalsocial.portalsocial.api.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfessorNomeInput {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	String curriculo;

}

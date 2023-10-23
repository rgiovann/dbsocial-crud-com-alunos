package com.portalsocial.portalsocial.api.input;


import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProfessorIdInput {
	
	@NotNull
	private Long id;

}

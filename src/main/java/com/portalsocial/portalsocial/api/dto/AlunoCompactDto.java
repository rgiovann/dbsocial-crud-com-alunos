package com.portalsocial.portalsocial.api.dto;

import com.portalsocial.portalsocial.domain.model.Aluno;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 public class AlunoCompactDto {

    private Long id;

    private String nome;
    private String cpf;
    private String email;

    AlunoCompactDto(Aluno aluno){
        this.setId(aluno.getId());
        this.setCpf(aluno.getCpf());
        this.setNome(aluno.getNome());
        this.setEmail(aluno.getEmail());
    }


}

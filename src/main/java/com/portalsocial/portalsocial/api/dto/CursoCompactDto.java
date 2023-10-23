package com.portalsocial.portalsocial.api.dto;

import com.portalsocial.portalsocial.domain.enumeration.RegimeCurso;
import com.portalsocial.portalsocial.domain.model.Curso;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoCompactDto {
    private Long id;
    private String nome;
    private String url;
    private String descricao;
    private RegimeCurso regime;

    private CategoriaDto categoria;

    public CursoCompactDto(Curso curso){
        this.setCategoria(new CategoriaDto((curso.getCategoria())));
        this.setId(curso.getId());
        this.setUrl(curso.getUrl());
        this.setDescricao(curso.getDescricao());
        this.setRegime(curso.getRegime());
        this.setNome(curso.getNome());
    }


}

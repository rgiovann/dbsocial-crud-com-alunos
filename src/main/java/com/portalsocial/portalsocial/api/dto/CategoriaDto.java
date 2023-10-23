package com.portalsocial.portalsocial.api.dto;

import com.portalsocial.portalsocial.domain.model.Categoria;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoriaDto {

    private Long id;

    private String nome;

    public CategoriaDto(Categoria categoria){
        this.setId(categoria.getId());
        this.setNome(categoria.getNome());

    }
}

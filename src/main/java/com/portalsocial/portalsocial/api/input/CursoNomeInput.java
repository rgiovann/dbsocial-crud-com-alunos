package com.portalsocial.portalsocial.api.input;

import com.portalsocial.portalsocial.domain.enumeration.RegimeCurso;
import com.portalsocial.portalsocial.domain.model.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoNomeInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String url;

    @NotBlank
    private String descricao;

    @NotBlank
    private String fornecedor;

    @NotNull
    private CategoriaInput categoria;

    private Long gostei=0L;

    private Long qtdadeHoras = 0L;

    private Long visualizacoes = 0L;

    private RegimeCurso regime;

    public Curso fromCursoInputToEntity( CursoNomeInput cursoNomeInput, Long id, Curso curso)
    {
        curso.setId(id);
        curso.setNome(cursoNomeInput.getNome());
        curso.setDescricao(cursoNomeInput.getDescricao());
        curso.setUrl(cursoNomeInput.getUrl());
        curso.setFornecedor(cursoNomeInput.getFornecedor());
        curso.setRegime(cursoNomeInput.getRegime());

        curso.setGostei((cursoNomeInput.getGostei()==null) ? 0L: cursoNomeInput.getGostei());
        curso.setVisualizacoes((cursoNomeInput.getVisualizacoes()==null) ? 0L: cursoNomeInput.getVisualizacoes());
        curso.setQtdadeHoras((cursoNomeInput.getQtdadeHoras()==null) ? 0L: cursoNomeInput.getQtdadeHoras());

        return curso;
    }


}

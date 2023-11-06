package com.portalsocial.portalsocial.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FotoCurso {
    @EqualsAndHashCode.Include
    @Id
    @Column(name="curso_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Curso curso;

    private String nomeArquivo;
    private String descricao;
    private String contentType;
    private Long tamanho;

    public Long getCursoId()
    {
        if(this.getCurso()!=null){
            return this.getCurso().getId();
        }
        return null;
    }
}

package com.portalsocial.portalsocial.domain.model;

import java.util.HashSet;
import java.util.Set;

import com.portalsocial.portalsocial.domain.enumeration.RegimeCurso;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="curso")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class Curso {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="curso_id")
    private Long id;

    @Column(name="curso_nome")
    private String nome;

    @Column(name="curso_descricao")
    private String descricao;

    @Column(name="curso_url")
    private String url;


    @Column(name="curso_fornecedor")
    private String fornecedor;

    @Column(name="curso_visualizacao")
    private Long visualizacoes;

    @Column(name="curso_gostei")
    private Long gostei;

    @Column(name="curso_qtd_hrs")
    private Long qtdadeHoras;

    @Column(name="curso_regime")
    @Enumerated(EnumType.STRING)
    private RegimeCurso regime;
    
    @ManyToOne
    @JoinColumn(name ="categoria_idcategoria")
    private Categoria categoria;

    @ManyToMany
    @JoinTable(name="aluno_curso",
    joinColumns = @JoinColumn(name="curso_idcurso"), 
    inverseJoinColumns= @JoinColumn(name="aluno_idaluno") )
    private Set<Aluno> alunos = new HashSet<Aluno>();

}

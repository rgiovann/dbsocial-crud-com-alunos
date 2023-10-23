package com.portalsocial.portalsocial.domain.model;

import java.time.LocalDate;

import com.portalsocial.portalsocial.domain.enumeration.Genero;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="aluno")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class Aluno {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="aluno_id")
    private Long id;

    @Column(name="aluno_cpf")
    private String cpf;

    @Column(name="aluno_nome")
    private String nome;

    @Column(name="aluno_contato")
    private String contato; 

    @Column(name="aluno_email")
    private String email;
    
    @Column(name="aluno_genero")
    @Enumerated(EnumType.STRING)
    private Genero genero; 

    @Column(name="aluno_data_nascimento")
    private LocalDate nascimento;

    @Column(name="aluno_cep")
    private String cep;

    @Column(name="aluno_logradouro")
    private String logradouro;

    @Column(name="aluno_bairro")
    private String bairro;

    @Column(name="aluno_cidade")
    private String cidade;

    @Column(name="aluno_estado")
    private String estado;

    @Column(name="aluno_nr_residencia")
    private String numero;

    @Column(name="aluno_endereco_complemento")
    private String complemento;  
    
    @Column(name="aluno_senha")
    private String senha;
    
}

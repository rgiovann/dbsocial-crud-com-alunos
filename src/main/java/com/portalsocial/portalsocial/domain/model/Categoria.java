package com.portalsocial.portalsocial.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="categoria")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper = false)
public class Categoria {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="categoria_id")
    private Long id;
    
        @Column(name="categoria_nome")
        private String nome;

}

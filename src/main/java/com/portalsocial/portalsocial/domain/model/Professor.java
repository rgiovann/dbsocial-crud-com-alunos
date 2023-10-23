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
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true,callSuper=false)
@Table(name = "professor")
public class Professor {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="professor_id")
	private Long id;
	
	@Column(name="professor_nome")
	private String nome;
 
	@Column(name="professor_curriculo")
	private String curriculo;
}

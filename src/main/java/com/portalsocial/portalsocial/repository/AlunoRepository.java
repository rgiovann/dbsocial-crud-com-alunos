package com.portalsocial.portalsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalsocial.portalsocial.domain.model.Curso;

public interface AlunoRepository extends JpaRepository<Curso, Long> {

}

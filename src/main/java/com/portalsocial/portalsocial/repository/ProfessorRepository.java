package com.portalsocial.portalsocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portalsocial.portalsocial.domain.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {

}

package com.portalsocial.portalsocial.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portalsocial.portalsocial.domain.exception.EntidadeEmUsoException;
import com.portalsocial.portalsocial.domain.exception.ProfessorNaoEncontradoException;
import com.portalsocial.portalsocial.domain.model.Professor;
import com.portalsocial.portalsocial.repository.ProfessorRepository;

@Service
public class CadastroProfessorService {

	private static final String MSG_ESTADO_EM_USO = "Professor de código %d não pode ser removido, pois está em uso.";
	private final ProfessorRepository professorRepository;

	public CadastroProfessorService(ProfessorRepository professorRepository) {
		this.professorRepository = professorRepository;

	}

 
	public List<Professor> listar() {

		return professorRepository.findAll();

	}

	@Transactional
	public Professor salvar(Professor professor) {

		return professorRepository.save(professor);
	}

	@Transactional
	public void excluir(Long professorId) {
		try {

			professorRepository.deleteById(professorId);
			
			professorRepository.flush();

		} catch (EmptyResultDataAccessException e) {
			throw new ProfessorNaoEncontradoException(professorId);
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(String.format(MSG_ESTADO_EM_USO, professorId));
		}

	}

	public Professor buscarOuFalhar(Long professorId) {
		return professorRepository.findById(professorId).orElseThrow(() -> new ProfessorNaoEncontradoException(professorId));
	}

}
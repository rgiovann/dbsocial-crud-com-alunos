package com.portalsocial.portalsocial.service;

import com.portalsocial.portalsocial.api.dto.CursoCompactDto;
import com.portalsocial.portalsocial.domain.exception.CursoNaoEncontradoException;
import com.portalsocial.portalsocial.domain.exception.EntidadeEmUsoException;
import com.portalsocial.portalsocial.domain.model.Curso;
import com.portalsocial.portalsocial.repository.CursoRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CadastroCursoService {

    private static final String MSG_CURSO_EM_USO = "Curso de código %d não pode ser removido, pois está em uso";
    private final CursoRepository cursoRepository;

    public CadastroCursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;

    }

    public List<CursoCompactDto> listar(){
        List<Curso> cursos = cursoRepository.findAll();

        /*Quando você usa cursos.stream().map(CursoCompactDto::new), o método map irá percorrer
        * cada elemento de cursos e irá chamar o construtor CursoCompactDto(Curso curso) para criar
        * uma instância de CursoCompactDto para cada objeto curso no stream. Dessa forma o método de
        * referência sabe que deve passar o objeto curso como parâmetro para o construtor da class
        * CursoCOmpactDto com base na assinatura do construtor*/

        return cursos.stream().map( CursoCompactDto::new).collect(Collectors.toList());
    }

    public Curso buscarOuFalhar(Long cursoId){
        return cursoRepository.findById(cursoId).orElseThrow( ()-> new CursoNaoEncontradoException(cursoId));
    }

    @Transactional
    public Curso salvar(Curso curso){
        return cursoRepository.save(curso);
    }


    @Transactional
    public void excluir(Long cursoId) {
        try{
        this.buscarOuFalhar(cursoId);
            cursoRepository.deleteById(cursoId);
            cursoRepository.flush();
        }
        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(String.format(MSG_CURSO_EM_USO,cursoId));
        }
        
    }
}

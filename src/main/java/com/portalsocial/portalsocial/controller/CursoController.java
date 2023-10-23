package com.portalsocial.portalsocial.controller;

import com.portalsocial.portalsocial.api.dto.CursoCompactDto;
import com.portalsocial.portalsocial.api.dto.CursoDto;
import com.portalsocial.portalsocial.api.input.CursoNomeInput;
import com.portalsocial.portalsocial.domain.model.Categoria;
import com.portalsocial.portalsocial.domain.model.Curso;
import com.portalsocial.portalsocial.service.CadastroCategoriaService;
import com.portalsocial.portalsocial.service.CadastroCursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/cursos")
public class CursoController {

    private final CadastroCursoService cadastroCursoService;
    private final CadastroCategoriaService cadastroCategoriaService;

    public CursoController(CadastroCursoService cadastroCursoService, CadastroCategoriaService cadastroCategoriaService){
        this.cadastroCursoService = cadastroCursoService;
        this.cadastroCategoriaService = cadastroCategoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CursoCompactDto>> listar(){
        return ResponseEntity.ok().body(cadastroCursoService.listar()) ;
    }

    @GetMapping("/{cursoId}")
    public ResponseEntity<CursoDto> buscar(@PathVariable Long cursoId){
        return ResponseEntity.ok().body(new CursoDto(cadastroCursoService.buscarOuFalhar(cursoId)));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDto adicionar(@RequestBody @Valid CursoNomeInput cursoNomeInput){

        Categoria categoria = cadastroCategoriaService.buscarOuFalhar(cursoNomeInput.getCategoria().getId());
        Curso curso= cursoNomeInput.fromCursoInputToEntity(cursoNomeInput,null,new Curso());
        curso.setCategoria(categoria);
        curso = cadastroCursoService.salvar(curso);

        return new CursoDto(curso);
    }

    @PutMapping({"/{cursoId}"})
    public CursoDto atualizar(@PathVariable Long cursoId, @RequestBody @Valid CursoNomeInput cursoNomeInput){
        Categoria categoria = cadastroCategoriaService.buscarOuFalhar(cursoNomeInput.getCategoria().getId());
        Curso curso = cadastroCursoService.buscarOuFalhar(cursoId);
        curso= cursoNomeInput.fromCursoInputToEntity(cursoNomeInput,cursoId,curso);
        curso.setCategoria(categoria);
        curso = cadastroCursoService.salvar(curso);
        return new CursoDto(curso);
    }

    @DeleteMapping({"/{cursoId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
            public void remover(@PathVariable Long cursoId)
    {
        cadastroCursoService.excluir(cursoId);
    }




}

package com.portalsocial.portalsocial.service;

import com.portalsocial.portalsocial.domain.exception.CategoriaNaoEncontradaException;
import com.portalsocial.portalsocial.domain.model.Categoria;
import com.portalsocial.portalsocial.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CadastroCategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CadastroCategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria buscarOuFalhar(Long categoriaId) throws CategoriaNaoEncontradaException {
        return categoriaRepository.findById(categoriaId).orElseThrow(()-> new CategoriaNaoEncontradaException(categoriaId));
    }

}

package com.fiap.springblog.service.impl;

import com.fiap.springblog.model.Autor;
import com.fiap.springblog.repository.AutorRepository;
import com.fiap.springblog.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

@Service
public class AutorServiceImpl implements AutorService {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public Autor criar(Autor autor) {
        return this.autorRepository.save(autor);
    }

    @Override
    public Autor obterPorCodigo(String codigo) {
        return this.autorRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Autor não existe!"));
    }
}

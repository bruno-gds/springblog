package com.fiap.springblog.service;

import com.fiap.springblog.model.Autor;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

public interface AutorService {
    public Autor criar(Autor autor);
    public Autor obterPorCodigo(String codigo);
}

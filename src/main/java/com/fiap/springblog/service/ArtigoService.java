package com.fiap.springblog.service;

import com.fiap.springblog.model.Artigo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

public interface ArtigoService {
    public List<Artigo> obterTodos();
    public Artigo obterPorCodigo(String codigo);
    public Artigo criar(Artigo artigo);
    public List<Artigo> findByDataGreaterThan(LocalDateTime data);
    public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status);
    public void atualizar(Artigo updatedArtigo);
    public void atualizarArtigo(String id, String novaUrl);
    public void deleteById(String id);
    public void deleteArtigoById(String id);
}
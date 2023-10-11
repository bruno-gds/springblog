package com.fiap.springblog.service.impl;

import com.fiap.springblog.model.Artigo;
import com.fiap.springblog.model.Autor;
import com.fiap.springblog.repository.ArtigoRepository;
import com.fiap.springblog.repository.AutorRepository;
import com.fiap.springblog.service.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

@Service
public class ArtigoServiceImpl implements ArtigoService {

    @Autowired
    private ArtigoRepository artigoRepository;

    @Autowired
    private AutorRepository autorRepository;

    private final MongoTemplate mongoTemplate;

    public ArtigoServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public List<Artigo> obterTodos() {
        return this.artigoRepository.findAll();
    }

    @Override
    public Artigo obterPorCodigo(String codigo) {
        return this.artigoRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Artigo não existe!"));
    }

    @Override
    public Artigo criar(Artigo artigo) {
        if (artigo.getAutor().getCodigo() != null){
            Autor autor = this.autorRepository
                    .findById(artigo.getAutor().getCodigo())
                    .orElseThrow(() -> new IllegalArgumentException("Autor não existe!"));

            artigo.setAutor(autor);
        } else {
            artigo.setAutor(null);
        }
        return this.artigoRepository.save(artigo);
    }

    @Override
    public List<Artigo> findByDataGreaterThan(LocalDateTime data) {
        Query query = new Query(Criteria.where("data").gt(data));

        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public List<Artigo> findByDataAndStatus(LocalDateTime data, Integer status) {
        Query query = new Query(Criteria.where("data").gt(data).and("status").is(status));

        return mongoTemplate.find(query, Artigo.class);
    }

    @Override
    public void atualizar(Artigo updatedArtigo) {
        this.artigoRepository.save(updatedArtigo);
    }

    @Override
    public void atualizarArtigo(String id, String novaUrl) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("url", novaUrl);

        this.mongoTemplate.updateFirst(query, update, Artigo.class);
    }

    @Override
    public void deleteById(String id){
        this.artigoRepository.deleteById(id);
    }

    @Override
    public void deleteArtigoById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        this.mongoTemplate.remove(query, Artigo.class);
    }
}

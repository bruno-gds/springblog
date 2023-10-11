package com.fiap.springblog.repository;

import com.fiap.springblog.model.Artigo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

public interface ArtigoRepository extends MongoRepository<Artigo, String> {

    public void deleteById(String id);
    public List<Artigo> findByStatusAndDataGreaterThan(Integer status, LocalDateTime data);
    public List<Artigo> findByStatusEquals(Integer status);

    @Query("{ $and: [{'data': { $gte: ?0 }}, {'data': { $lte: ?1 }}] }")
    public List<Artigo> obterArtigoPorDataHora(LocalDateTime de, LocalDateTime ate);

    Page<Artigo> findAll(Pageable pageable);
    public List<Artigo> findByStatusOrderByTituloAsc(Integer status);
}

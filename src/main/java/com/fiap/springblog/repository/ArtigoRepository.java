package com.fiap.springblog.repository;

import com.fiap.springblog.model.Artigo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

public interface ArtigoRepository extends MongoRepository<Artigo, String> {

    public void deleteById(String id);
}

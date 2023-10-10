package com.fiap.springblog.repository;

import com.fiap.springblog.model.Autor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

public interface AutorRepository extends MongoRepository<Autor, String> {
}

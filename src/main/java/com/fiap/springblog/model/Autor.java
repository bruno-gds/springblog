package com.fiap.springblog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

@Document
@Data
public class Autor {
    @Id
    private String codigo;
    private String nome;
    private String biografia;
    private String imagem;
}

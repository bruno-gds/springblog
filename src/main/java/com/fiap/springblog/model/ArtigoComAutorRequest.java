package com.fiap.springblog.model;

import lombok.Data;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 18/10/2023
 * Project Name: springblog
 */

@Data
public class ArtigoComAutorRequest {
    private Artigo artigo;
    private Autor autor;
}

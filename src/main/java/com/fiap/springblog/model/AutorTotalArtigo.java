package com.fiap.springblog.model;

import lombok.Data;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 11/10/2023
 * Project Name: springblog
 */

@Data
public class AutorTotalArtigo {
    private Autor autor;
    private Long totalArtigos;
}
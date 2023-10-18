package com.fiap.springblog.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 10/10/2023
 * Project Name: springblog
 */

@Document
@Data
public class Artigo {
    @Id
    private String codigo;

    @NotBlank(message = "O Título do Artigo não pode estar em branco.")
    private String titulo;

    @NotNull(message = "A Data do Artigo não pode ser nula.")
    private LocalDateTime data;

    @NotBlank(message = "O Texto do Artigo não pode estar em branco.")
    @TextIndexed // PARA INDEXAR O CAMPO NO DB
    private String texto;

    private String url;

    @NotNull(message = "O Status do Artigo não pode ser nulo.")
    private Integer status;

    @DBRef
    private Autor autor;

    @Version
    private Long version;
}

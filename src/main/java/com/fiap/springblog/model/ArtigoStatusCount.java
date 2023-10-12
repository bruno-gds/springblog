package com.fiap.springblog.model;

import lombok.Data;

/**
 * @author Bruno Gomes Damascena dos santos (bruno-gds) < brunog.damascena@gmail.com >
 * Date: 11/10/2023
 * Project Name: springblog
 */

@Data
public class ArtigoStatusCount {
    private Integer status;
    private Long quantidade;
}

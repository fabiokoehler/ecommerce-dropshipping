package com.koehler.fornecedor.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {

    private String sku;
    private Long quantidade;
    private BigDecimal total;
    

}

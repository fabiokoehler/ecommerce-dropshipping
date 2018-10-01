package com.koehler.wholesaler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
public class OrderLine {

    @Id
    private String id;
    private String sku;
    private Long quantity;
    private BigDecimal total;
    

}

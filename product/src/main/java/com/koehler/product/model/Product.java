package com.koehler.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private List<Images> images;
    private BigDecimal price;
    private String sku;
    private Long stock;
    private List<Category> categories;
    

}

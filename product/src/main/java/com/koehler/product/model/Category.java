package com.koehler.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Category {

    @Id
    private String id;
    private String name;
}

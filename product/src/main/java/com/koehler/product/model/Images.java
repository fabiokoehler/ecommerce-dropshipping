package com.koehler.product.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Images {

    @Id
    private String id;
    private String miniUrl;
    private String largeUrl;

}

package com.koehler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Payment {

    @Id
    private String id;
    private Long orderNumber;
    private String status;

}

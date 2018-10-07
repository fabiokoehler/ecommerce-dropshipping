package com.koehler.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {

    @Id
    private String id;
    private String name;
    private String address;

}

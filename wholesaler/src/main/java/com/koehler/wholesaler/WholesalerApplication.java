package com.koehler.wholesaler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.koehler.wholesaler.client")
public class WholesalerApplication {

    public static void main(String[] args) {

        SpringApplication.run(WholesalerApplication.class, args);
    }
}

package com.koehler.order.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Order {

    @Id
    private String id;
    private Long number;
    // enum pending, processing, payment-approved, on-hold, completed, cancelled, refunded and failed
    private String status;
    private BigDecimal total;
    private Address billing;
    private Address shipping;
    private List<OrderLine> lines;
    private Customer customer;

}

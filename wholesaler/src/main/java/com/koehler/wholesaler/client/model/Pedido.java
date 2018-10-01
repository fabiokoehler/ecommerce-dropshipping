package com.koehler.wholesaler.client.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Pedido {

    private Long numero;
    private String status;
    private BigDecimal total;
    private Endereco cobranca;
    private Endereco entrega;
    private List<Item> itens;
    private Cliente cliente;

}

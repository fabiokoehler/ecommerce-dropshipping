package com.koehler.wholesaler.controller;

import com.koehler.wholesaler.client.FornecedorClient;
import com.koehler.wholesaler.client.model.Pedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class WholesalerController {

    @Autowired
    private FornecedorClient client;

    @GetMapping("/wholesaler")
    public Pedido all() {

        Pedido pedido = new Pedido();
        pedido.setNumero(123l);
        pedido.setTotal(BigDecimal.TEN);

        return client.efetuarPedido(pedido);

    }
}

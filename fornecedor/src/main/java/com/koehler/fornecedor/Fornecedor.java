package com.koehler.fornecedor;

import com.koehler.fornecedor.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Fornecedor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Fornecedor.class);

    @PostMapping("/pedido")
    public Pedido efetuarPedido(@RequestBody Pedido pedido) {

        LOGGER.info("Fornecedor recebeu pedido: ", pedido);

        pedido.setStatus("CONFIRMADO");

        return pedido;
    }

}

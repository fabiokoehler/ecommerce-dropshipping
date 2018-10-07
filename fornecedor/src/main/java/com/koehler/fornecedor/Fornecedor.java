package com.koehler.fornecedor;

import com.koehler.fornecedor.model.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Fornecedor {

    private static final Logger LOGGER = LoggerFactory.getLogger(Fornecedor.class);

    @PostMapping("/pedido")
    public Pedido efetuarPedido(@RequestBody Pedido pedido) {

        LOGGER.info("Fornecedor recebeu pedido: " + pedido);

        pedido.setStatus("CONFIRMADO");

        return pedido;
    }

    @GetMapping("/pedido")
    public ResponseEntity getPedido() {
        Pedido pedido = new Pedido();
        pedido.setStatus("CONFIRMADO");
        LOGGER.info("Fornecedor recebeu pedido: " + pedido);
        return ResponseEntity.status(HttpStatus.OK).body(pedido);
    }

}

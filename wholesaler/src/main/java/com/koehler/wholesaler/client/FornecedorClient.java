package com.koehler.wholesaler.client;

import com.koehler.wholesaler.client.model.Pedido;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(url="https://localhost:8080" , name = "FornecedorClient")
public interface FornecedorClient {

    @PostMapping("/pedido")
    Pedido efetuarPedido(@RequestBody Pedido pedido);

}

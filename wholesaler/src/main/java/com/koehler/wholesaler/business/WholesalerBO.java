package com.koehler.wholesaler.business;

import com.koehler.wholesaler.broker.wholesaler.WholesalerSender;
import com.koehler.wholesaler.client.FornecedorClient;
import com.koehler.wholesaler.client.model.Pedido;
import com.koehler.wholesaler.model.Order;
import com.koehler.wholesaler.repository.WholesalerRepository;
import feign.Feign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WholesalerBO {

    @Autowired
    private WholesalerRepository repository;

    @Autowired
    private WholesalerSender wholesalerSender;

    @Autowired
    private FornecedorClient fornecedorClient;

    public void processWholesalerCall(Order order) {

        // if payment status is approved
        // send message with order status = confirm wholesaler
        // update order status with payment approved

        //wWholesaler client

        // if result successfully


        Feign.builder().target(FornecedorClient.class, "http://localhost:8080/pedido").efetuarPedido(new Pedido());

        order.setStatus("WHOLESALER-APPROVED");

        wholesalerSender.send(order);
    }

}

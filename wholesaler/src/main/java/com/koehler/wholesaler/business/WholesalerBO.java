package com.koehler.wholesaler.business;

import com.koehler.wholesaler.broker.wholesaler.WholesalerSender;
import com.koehler.wholesaler.client.FornecedorClient;
import com.koehler.wholesaler.client.model.Cliente;
import com.koehler.wholesaler.client.model.Endereco;
import com.koehler.wholesaler.client.model.Item;
import com.koehler.wholesaler.client.model.Pedido;
import com.koehler.model.Order;
import com.koehler.model.OrderLine;
import com.koehler.wholesaler.repository.WholesalerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WholesalerBO {

    private static final Logger LOGGER = LoggerFactory.getLogger(WholesalerBO.class);

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

        Pedido pedido = new Pedido();
        pedido.setNumero(order.getNumber());
        pedido.setTotal(order.getTotal());

        Cliente cliente = new Cliente();
        cliente.setNome(order.getCustomer().getName());
        pedido.setCliente(cliente);
        Endereco cobranca = new Endereco();
        cobranca.setNome(order.getBilling().getName());
        cobranca.setEndereco(order.getBilling().getAddress());
        pedido.setCobranca(cobranca);

        Endereco entrega = new Endereco();
        entrega.setNome(order.getShipping().getName());
        entrega.setEndereco(order.getShipping().getAddress());
        pedido.setEntrega(entrega);

        List<Item> itens = new ArrayList<>();

        for (OrderLine line : order.getLines()) {
            Item item = new Item();
            item.setSku(line.getSku());
            item.setQuantidade(line.getQuantity());
            item.setTotal(line.getTotal());
            itens.add(item);
        }

        pedido.setItens(itens);

        Pedido pedidoResponse = fornecedorClient.efetuarPedido(pedido);
        if ("CONFIRMADO".equals(pedidoResponse.getStatus())) {
            order.setStatus("WHOLESALER-APPROVED");
            wholesalerSender.send(order);
        } else {
            LOGGER.warn("Order rejected by the wholesaler", pedido);
        }
    }
}

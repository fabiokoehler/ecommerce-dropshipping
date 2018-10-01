package com.koehler.wholesaler.business;

import com.koehler.wholesaler.broker.wholesaler.WholesalerSender;
import com.koehler.wholesaler.model.Order;
import com.koehler.wholesaler.repository.WholesalerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WholesalerBO {

    @Autowired
    private WholesalerRepository repository;

    @Autowired
    private WholesalerSender wholesalerSender;

    public void processWholesalerCall(Order order) {

        // if payment status is approved
        // send message with order status = confirm wholesaler
        // update order status with payment approved

        //wWholesaler client

        // if result successfully

        order.setStatus("WHOLESALER-APPROVED");

        wholesalerSender.send(order);
    }
}

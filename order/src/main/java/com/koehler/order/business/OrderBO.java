package com.koehler.order.business;

import com.koehler.order.broker.order.OrderSender;
import com.koehler.model.Order;
import com.koehler.model.Payment;
import com.koehler.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderBO {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderSender orderSender;

    public void processPaymentResponse(Payment payment) {

        // if payment status is approved
        // send message with order status = confirm wholesaler
        // update order status with payment approved
        // business logic would be here....
        Order order = repository.findByNumber(payment.getOrderNumber());
        order.setStatus("PAYMENT-APPROVED");
        repository.save(order);

        // send message that the payment was approved
        orderSender.send(order);
    }

    public void processWholesalerResponse(Order wholesalerOrder) {

        Order order = repository.findByNumber(wholesalerOrder.getNumber());
        order.setStatus("COMPLETE");
        repository.save(order);

        //send status complete, next step would be the customer confirmation
        orderSender.send(order);
    }
}

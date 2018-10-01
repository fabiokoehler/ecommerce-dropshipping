package com.koehler.wholesaler.broker.order;

import com.koehler.wholesaler.business.WholesalerBO;
import com.koehler.wholesaler.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class OrderReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderReceiver.class);

    @Autowired
    private WholesalerBO wholesalerBO;

    @KafkaListener(topics = "${kafka.topic.order-state-machine}")
    public void receive(Order order) {

        LOGGER.info("Sending order to the wholesaler='{}'", order);

        //migrate to strategy patter to process accordingly the status
        if(order != null && "PAYMENT-APPROVED".equals(order.getStatus())) {
            // process after payment
            // send request

            wholesalerBO.processWholesalerCall(order);
        }


    }
}

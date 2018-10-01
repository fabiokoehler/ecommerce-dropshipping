package com.koehler.order.broker.order;

import com.koehler.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

public class OrderReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderReceiver.class);

    @KafkaListener(topics = "${kafka.topic.order-state-machine}")
    public void receive(Order order) {

        //migrate to strategy patter to process accordingly the status
        if(order != null && "PAYMENT APPROVED".equals(order.getStatus())) {
            // process after payment
            // send request
        }

        LOGGER.info("received payload='{}'", order);
    }
}

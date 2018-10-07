package com.koehler.order.broker.wholesaler;

import com.koehler.order.business.OrderBO;
import com.koehler.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class WholesalerReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(WholesalerReceiver.class);

    @Autowired
    private OrderBO orderBO;

    @KafkaListener(topics = "${kafka.topic.wholesaler-status}", containerFactory="kafkaListenerContainerFactoryWholesaler")
    public void receive(Order order) {

        LOGGER.info("processing wholesaler response='{}'", order);

        //migrate to strategy patter to process accordingly the status
        if(order != null && "WHOLESALER-APPROVED".equals(order.getStatus())) {
            // process after payment
            // send request
            orderBO.processWholesalerResponse(order);
        }


    }
}

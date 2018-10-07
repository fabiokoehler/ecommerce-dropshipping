package com.koehler.wholesaler.broker.wholesaler;

import com.koehler.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

public class WholesalerSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(WholesalerSender.class);

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${kafka.topic.wholesaler-status}")
    private String topic;

    public void send(Order payload) {
        LOGGER.info("sending order='{}'", payload);
        kafkaTemplate.send(topic, payload);
    }
}

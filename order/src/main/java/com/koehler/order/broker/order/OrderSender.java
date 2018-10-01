package com.koehler.order.broker.order;

import com.koehler.order.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderSender.class);

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    @Value("${kafka.topic.order-state-machine}")
    private String topic;

    public void send(Order payload) {
        LOGGER.info("sending order='{}'", payload);
        kafkaTemplate.send(topic, payload);
    }
}

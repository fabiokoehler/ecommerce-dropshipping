package com.koehler.order.broker.payment;

import com.koehler.order.business.OrderBO;
import com.koehler.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class PaymentReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentReceiver.class);

    @Autowired
    private OrderBO orderBO;

    @KafkaListener(topics = "${kafka.topic.payment-status}", containerFactory="kafkaListenerContainerFactoryPayment")
    public void receive(Payment payment) {
        LOGGER.info("Payment update event='{}'", payment);

        if (payment != null && "PAYMENT-APPROVED".equals(payment.getStatus())) {
            orderBO.processPaymentResponse(payment);
        }
    }
}

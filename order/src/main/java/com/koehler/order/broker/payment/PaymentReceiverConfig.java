package com.koehler.order.broker.payment;

import com.koehler.order.broker.KafkaConsumerConfiguration;
import com.koehler.model.Payment;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
@EnableKafka
public class PaymentReceiverConfig extends KafkaConsumerConfiguration {

    @Bean
    public ConsumerFactory<String, Payment> consumerFactoryPayment() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(Payment.class));
    }

    @Bean(name="kafkaListenerContainerFactoryPayment")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Payment>> kafkaListenerContainerFactoryPayment() {
        ConcurrentKafkaListenerContainerFactory<String, Payment> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryPayment());

        return factory;
    }

    @Bean
    public PaymentReceiver receiverPayment() {
        return new PaymentReceiver();
    }
}
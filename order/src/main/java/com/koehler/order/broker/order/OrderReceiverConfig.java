package com.koehler.order.broker.order;

import com.koehler.order.broker.KafkaConsumerConfiguration;
import com.koehler.model.Order;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
//@EnableKafka
public class OrderReceiverConfig extends KafkaConsumerConfiguration {

    @Bean
    public ConsumerFactory<String, Order> consumerFactoryOrder() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(Order.class));
    }

    @Bean(name="kafkaListenerContainerFactoryOrder")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Order>> kafkaListenerContainerFactoryOrder() {
        ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryOrder());

        return factory;
    }

    @Bean
    public OrderReceiver receiverOrder() {
        return new OrderReceiver();
    }
}
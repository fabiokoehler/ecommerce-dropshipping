package com.koehler.order.broker.wholesaler;

import com.koehler.order.broker.KafkaConsumerConfiguration;
import com.koehler.model.Order;
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
public class WholesalerReceiverConfig extends KafkaConsumerConfiguration {

    @Bean
    public ConsumerFactory<String, Order> consumerFactoryWholesaler() {
        return new DefaultKafkaConsumerFactory<>(
                consumerConfigs(),
                new StringDeserializer(),
                new JsonDeserializer<>(Order.class));
    }

    @Bean(name="kafkaListenerContainerFactoryWholesaler")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Order>> kafkaListenerContainerFactoryWholesaler() {
        ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactoryWholesaler());

        return factory;
    }

    @Bean
    public WholesalerReceiver receiverWholesaler() {
        return new WholesalerReceiver();
    }
}
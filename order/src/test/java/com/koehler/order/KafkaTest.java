package com.koehler.order;

import com.koehler.order.broker.order.OrderReceiver;
import com.koehler.order.broker.order.OrderSender;
import com.koehler.order.model.Order;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class KafkaTest {

	private static final String ORDER_STATE_MACHINE = "order-state-machine";

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, ORDER_STATE_MACHINE);

	@Autowired
	private OrderReceiver orderReceiver;

	@Autowired
	private OrderSender orderSender;

	@Test
	public void testReceive() throws Exception {

        Order order = new Order();
        order.setNumber(123l);

		orderSender.send(order);

	}
}

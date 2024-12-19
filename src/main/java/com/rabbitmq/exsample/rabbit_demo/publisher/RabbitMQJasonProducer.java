package com.rabbitmq.exsample.rabbit_demo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.rabbitmq.exsample.rabbit_demo.dto.User;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJasonProducer {
private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJasonProducer.class);

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitMQJasonProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
LOGGER.info("Jsom message sent "+ user.toString());
rabbitTemplate.convertAndSend(exchange,routingJsonKey,user);
    }
}

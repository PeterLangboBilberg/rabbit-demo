package com.rabbitmq.exsample.rabbit_demo.consumer;

import com.rabbitmq.exsample.rabbit_demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.jsonqueue.name}"})
    public void consumeJsomMessage(User user){
        LOGGER.info("Goet user from rabbitMQ "+user.toString());
    }


}

package com.rabbitmq.exsample.rabbit_demo.controller;

import com.rabbitmq.exsample.rabbit_demo.dto.User;
import com.rabbitmq.exsample.rabbit_demo.publisher.RabbitMQJasonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageJasonController {

    private RabbitMQJasonProducer jsonProducer;

    public MessageJasonController(RabbitMQJasonProducer jsonProducer) {
        this.jsonProducer = jsonProducer;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json sent");
    }
}

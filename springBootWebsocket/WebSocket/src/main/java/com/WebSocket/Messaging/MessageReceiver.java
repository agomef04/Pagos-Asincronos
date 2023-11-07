package com.WebSocket.Messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

    @RabbitListener(queues = "spring-boot")
    public void receivedMessage(String message) {
        System.out.println("Received message: " + message);

        // Realizar acciones del mensaje
    }
}

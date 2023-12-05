package com.example.RabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void sendMessage(String queueName, String message, int idTransfer, String idConexion) {

        String msg = message + ", " + idConexion;

        rabbitTemplate.convertAndSend(queueName, msg);
    }

}

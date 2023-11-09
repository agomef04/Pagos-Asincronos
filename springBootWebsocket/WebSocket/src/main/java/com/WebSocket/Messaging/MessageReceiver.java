package com.WebSocket.Messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MessageReceiver {
   // @Autowired
    //private WebSocketController webSocketController;

    @RabbitListener(queues = "spring-boot")
    public void receivedMessage(String message) {
        System.out.println("Received message: " + message);
        // String msg = message + " IdTransferencia: " + idTransfer + "IdConexion: " + idConexion;
        String estado = "";
        String id = "";
        Pattern pattern = Pattern.compile("^(.+) ID: (\\d+)$");
        Matcher matcher = pattern.matcher(message);

        if(matcher.find()) {
            estado = matcher.group(1);
            id = matcher.group(2);

        }

        if(estado == "Aceptado") {

        }
        if(estado == "Rechazado") {

        }

        //webSocketController.sendToUser(email, message);

    }
}

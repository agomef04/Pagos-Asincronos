package com.WebSocket.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketMessageSender {

    private final CustomWebSocketHandler customWebSocketHandler;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public WebSocketMessageSender(CustomWebSocketHandler customWebSocketHandler) {
        this.customWebSocketHandler = customWebSocketHandler;
    }

    @RabbitListener(queues = "spring-boot")
    public void sendMessageToUser(String message) {
        System.out.println("\t * Received message: " + message);
        // String msg = message + ", " + idConexion;
        String[] parts = message.split(", ");
        String estado = parts[0].trim();
        String sessionId = parts[1].trim();

        String canal = customWebSocketHandler.getSessionById(sessionId);
        System.out.println("\t(" + sessionId + "," + canal.toString() + ")");

        if(estado.equals("Aceptado")) {
            try {
                messagingTemplate.convertAndSend(canal, "Pago aceptado");
                System.out.println("Mensaje enviado exitosamente a: " + canal);
            } catch (Exception e) {
                System.out.println("Error al enviar el mensaje a: " + canal);
                e.printStackTrace();
            }
        }
        if(estado.equals("Rechazada")) {
            try {
                messagingTemplate.convertAndSend(canal, "Pago rechazado");
                System.out.println("Mensaje enviado exitosamente a: " + canal);
            } catch (Exception e) {
                System.out.println("Error al enviar el mensaje a: " + canal);
                e.printStackTrace();
            }
        }

    }





}

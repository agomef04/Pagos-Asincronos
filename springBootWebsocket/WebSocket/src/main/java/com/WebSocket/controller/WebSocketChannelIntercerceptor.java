package com.WebSocket.controller;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;

public class WebSocketChannelIntercerceptor implements ChannelInterceptor {

    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);

        if (StompCommand.CONNECT.equals(headerAccessor.getCommand())) {
            String sessionId = headerAccessor.getSessionId();
            System.out.println("ID de conexion websocket --> " + sessionId);
            // Aquí se ha establecido una conexión WebSocket.
            // Puedes registrar o manejar esa conexión en tu aplicación.
        }
    }
}

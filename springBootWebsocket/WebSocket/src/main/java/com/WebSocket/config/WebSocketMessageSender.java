package com.WebSocket.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;

@Component
public class WebSocketMessageSender {


    private final WebSocketSessionRegistry sessionRegistry;

    public WebSocketMessageSender(WebSocketSessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void sendMessageToUser(String sessionId, String message) {
        WebSocketSession userSession = sessionRegistry.getSession(sessionId);

        if(userSession != null && userSession.isOpen()) {
            try {
                userSession.sendMessage(new TextMessage(message));
            }catch (IOException e) {

            }
        }else {
            //Sesion no disponible o cerrada
        }
    }
}

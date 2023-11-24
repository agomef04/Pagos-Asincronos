package com.WebSocket.config;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomWebSocketHandler {

    private final Map<String, String> sessions = new ConcurrentHashMap<>();

    public void addSession(String sessionId, String session) {
        sessions.put(sessionId, session);
    }

    public String getSessionById(String sessionId) {
        return sessions.get(sessionId);
    }


    // Resto de tu implementación para el manejo de sesiones WebSocket
}

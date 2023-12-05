package com.WebSocket.config;

import org.springframework.stereotype.Component;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CustomWebSocketHandler {

    private final Map<String, String> sessions = new ConcurrentHashMap<>();

    public void addSession(String sessionId, String session) {
        sessions.put(sessionId, session);
    }

    public void removeSesion(String sessionId) {
        sessions.remove(sessionId);
    }

    public String getSessionById(String sessionId) {
        return sessions.get(sessionId);
    }


}

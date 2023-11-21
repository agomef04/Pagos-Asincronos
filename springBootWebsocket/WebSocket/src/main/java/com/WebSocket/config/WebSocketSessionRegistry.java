package com.WebSocket.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class WebSocketSessionRegistry {

    private  Map<String, WebSocketSession> sessionMap;

    public WebSocketSessionRegistry() {
        sessionMap =  new ConcurrentHashMap<String, WebSocketSession>();
    }

    public void registerSession(String username, WebSocketSession session) {
        sessionMap.put(username, session);
    }

    public WebSocketSession getSession(String username) {
        return sessionMap.get(username);
    }

    public void removeSession(String username) {
        sessionMap.remove(username);
    }
}

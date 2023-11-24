package com.WebSocket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.WebSocketSession;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {

        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/ws-endpoint")
    public void connect(@Payload String sessionId, WebSocketSession session) {
        sessions.put(sessionId,session);
        System.out.println("Session ***-->  " + session);
    }

    public void sendMessageToSession(String sesionId, Object message) {
        WebSocketSession session = sessions.get(sesionId);
        if(session != null && session.isOpen()) {
            messagingTemplate.convertAndSendToUser(sesionId, "/.../", message);
        }else {

        }
    }



}

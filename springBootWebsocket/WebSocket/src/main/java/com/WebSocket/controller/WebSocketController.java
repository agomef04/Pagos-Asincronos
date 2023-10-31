package com.WebSocket.controller;

import com.WebSocket.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {

    @MessageMapping("/topic/message")
    public void sendMessage(String message) {
        System.out.println(message);
    }
}

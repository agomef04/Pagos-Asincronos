package com.WebSocket.config;

import com.WebSocket.config.WebSocketSessionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.web.socket.WebSocketSession;

public class WebSocketChannelIntercerceptor implements ChannelInterceptor {
    
    @Autowired
    private WebSocketSessionRegistry sessionRegistry;
    
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel, boolean sent, Exception ex) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        System.out.println("CONEX MESSGAGE -> " + message.toString());

        if (StompCommand.CONNECT.equals(headerAccessor.getCommand())) {
            String sessionId = headerAccessor.getSessionId();
            System.out.println("SessionID  OPEN --------------> " + sessionId);
            WebSocketSession session = (WebSocketSession) message.getHeaders().get("webSocketSession");
            //System.out.println("Sesion --> " + session.toString());
            //sessionRegistry.registerSession(sessionId, session);
        }else if(StompCommand.DISCONNECT.equals(headerAccessor.getCommand())) {
            String sessionId = headerAccessor.getSessionId();
            System.out.println("SessionID  CLOSE  --------------> " + sessionId);
        }
    }

}

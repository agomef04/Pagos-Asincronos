package com.WebSocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    private final CustomWebSocketHandler customWebSocketHandler;

    public WebSocketConfig(CustomWebSocketHandler customWebSocketHandler) {
        this.customWebSocketHandler = customWebSocketHandler;
        WebSocketMessageSender webSocketMessageSender = new WebSocketMessageSender(customWebSocketHandler);
    }


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic"); // habilita un broker para los canales de los mensajes
        config.setApplicationDestinationPrefixes("/app");     // prefijo para las rutas de los mensajes
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-endpoint").setAllowedOrigins("http://localhost:4200").withSockJS();    // configura el punto de conexion webSocket
    }

    /**
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new WebSocketChannelIntercerceptor());
    }
    */
    @Override
    public void configureClientInboundChannel(ChannelRegistration registration) {
        registration.interceptors(new ChannelInterceptorAdapter() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                System.out.println("CONEX MESSGAGE -> " + message.toString());
                StompHeaderAccessor accessor = StompHeaderAccessor.wrap(message);
                if (StompCommand.SUBSCRIBE.equals(accessor.getCommand())) {
                    // Guardar la sesión WebSocket con su identificador al establecer la conexión
                    String sessionId = accessor.getSessionId();
                    SimpMessagingTemplate simpMessagingTemplate = new SimpMessagingTemplate(channel);
                    //WebSocketSession session = (WebSocketSession) message.getHeaders().get("simpSessionAttributes").get("HTTP_SESSION");
                    //System.out.println("\t(" + sessionId + "," + simpMessagingTemplate.toString() + ")");
                    System.out.println("\t(" + sessionId + "," + accessor.getDestination() + ")");
                    customWebSocketHandler.addSession(sessionId, accessor.getDestination());
                }
                return message;
            }
        });
    }

}


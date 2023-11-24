package com.WebSocket;

import com.WebSocket.model.*;
import com.WebSocket.repository.*;
import com.WebSocket.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@SpringBootApplication
public class WebSocketApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(WebSocketApplication.class);
	}

}

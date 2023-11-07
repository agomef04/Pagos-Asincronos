package com.example.RabbitMQ;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final MessageSender messageSender;

    public Runner(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void run(String... args) {
        messageSender.sendMessage("spring-boot", "Se puede realizar esta transferencia :");
    }
}


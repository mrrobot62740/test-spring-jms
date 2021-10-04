package com.example.testspringjms.sender;

import com.example.testspringjms.config.JmsConfig;
import com.example.testspringjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloSender {
    private final JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 2000)
    public void sendMessage() {
        System.out.println("I'm sending a message");
        HelloWorldMessage helloWorldMessage = HelloWorldMessage.builder()
                .id(UUID.randomUUID())
                .message("Hello World!")
                .build();

        jmsTemplate.convertAndSend(JmsConfig.MY_QUEUE, helloWorldMessage);

        System.out.println("Message sent!");
    }
}

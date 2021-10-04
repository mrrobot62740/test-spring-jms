package com.example.testspringjms.listener;

import com.example.testspringjms.config.JmsConfig;
import com.example.testspringjms.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class HelloListener {

    @JmsListener(destination = JmsConfig.MY_QUEUE)
    public void listen(@Payload HelloWorldMessage helloWorldMessage,
                       @Headers MessageHeaders headers,
                       Message message) {
        System.out.println("I got a message !!!!");
        System.out.println(helloWorldMessage);

        //throw new RuntimeException("foo");
    }

}

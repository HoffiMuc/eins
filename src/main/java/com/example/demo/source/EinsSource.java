package com.example.demo.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.example.demo.channels.EinsProcessor;

@Component
public class EinsSource {
    private static final Logger log = LoggerFactory.getLogger(EinsSource.class);

    @SendTo(EinsProcessor.OUTPUT)
    public String einsSend(String messageToSend) {
        String transformedMessage = messageToSend + "->einsSendTransformed";
        log.info("sending downstream: '{}'", transformedMessage);
        return messageToSend;
    }

}

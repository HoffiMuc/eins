package com.example.demo.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.channels.EinsProcessor;

@Component
public class EinsSource {
    private static final Logger log = LoggerFactory.getLogger(EinsSource.class);

    @Autowired
    @Qualifier(EinsProcessor.OUTPUT)
    private MessageChannel einsOutput;

    @SendTo(EinsProcessor.OUTPUT)
    public void einsSend(String messageToSend) {
        String transformedMessage = messageToSend + "->einsSendTransformed";
        log.info("sending downstream: '{}'", transformedMessage);
        this.einsOutput.send(MessageBuilder.withPayload(transformedMessage).build());
    }

}

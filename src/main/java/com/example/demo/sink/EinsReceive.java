package com.example.demo.sink;

import com.example.demo.channels.EinsProcessor;
import com.example.demo.source.EinsSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class EinsReceive {
    private static final Logger log = LoggerFactory.getLogger(EinsReceive.class);

    public static String lastMessage;

    @Autowired
    private EinsSource einsSource;

    @StreamListener(EinsProcessor.INPUT)
    public void einsReceive(String message, Message<String> wholeMessage) {
        EinsReceive.lastMessage = message;
        log.info("received: {}", wholeMessage);
        String transformedString = message + "->einsRecieveTransformed";
        this.einsSource.einsSend(transformedString);
    }

}

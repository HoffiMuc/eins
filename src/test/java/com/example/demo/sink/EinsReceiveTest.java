package com.example.demo.sink;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;

import com.example.demo.channels.EinsProcessor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EinsReceiveTest {

    @Autowired
    private EinsProcessor channel;

    @SpyBean
    private EinsReceive einsReceive;

    @Test
    public void einsReceiveTest() {
        String messageDtoToSend = "Testmessage ==> premodified";
        Message<String> message = MessageBuilder.withPayload(messageDtoToSend).build();
        this.channel.einsInput().send(message);

        verify(einsReceive).einsReceive(anyString(), any());
        assertEquals("Testmessage ==> premodified", einsReceive.lastMessage);

    }
}

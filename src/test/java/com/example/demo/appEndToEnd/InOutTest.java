package com.example.demo.appEndToEnd;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import com.example.demo.channels.EinsProcessor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJson;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureCache
@AutoConfigureJson
@AutoConfigureJsonTesters
@DirtiesContext
public class InOutTest {
    @Autowired
    private EinsProcessor channel;

    // @Autowired
    // private JacksonTester<MessageDTO> json;

    @Autowired
    private MessageCollector messageCollector;

    @Test
    public void whenSendMessage_thenResponseShouldBeTransformed() throws IOException {
        // MessageDTO messageDtoToSend = new MessageDTO("Testmessage", "==> premodified");
        // Message<MessageDTO> message = MessageBuilder.withPayload(messageDtoToSend).build();
        String messageDtoToSend = "Testmessage ==> premodified";
        // Message<MessageDTO> message = MessageBuilder.withPayload(messageDtoToSend).build();
        Message<String> message = MessageBuilder.withPayload(messageDtoToSend).build();
        this.channel.einsInput().send(message);

        String receivedPayloadString = (String) this.messageCollector.forChannel(this.channel.einsOutput()).poll().getPayload();
        System.out.println(receivedPayloadString);
        // MessageDTO receivedDTO = this.json.parse(receivedPayloadString).getObject();


        assertEquals("Testmessage ==> premodified->einsRecieveTransformed->einsSendTransformed", receivedPayloadString);
        // assertEquals("==> premodified ==> MessageTransformator:i0:MessageTransformator", receivedDTO.modifiers);
    }
}
package com.example.demo.source;

import static org.junit.Assert.assertEquals;

import com.example.demo.channels.EinsProcessor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.test.binder.MessageCollector;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EinsSourceTest {

    @Autowired
    private EinsProcessor channel;

    @Autowired
    private MessageCollector messageCollector;

    @Autowired
    private EinsSource einsSource;

    @Test
    public void einsSendTest() {
        einsSource.einsSend("Testmessage ==> premodified");

        String receivedPayloadString = (String) this.messageCollector.forChannel(this.channel.einsOutput()).poll()
                .getPayload();
        assertEquals("Testmessage ==> premodified->einsSendTransformed", receivedPayloadString);

    }

}

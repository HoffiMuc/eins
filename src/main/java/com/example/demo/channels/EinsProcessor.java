package com.example.demo.channels;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EinsProcessor {

    String INPUT = "fromOutsideChannel";
    String OUTPUT = "eins2zweiChannel";

    @Input(INPUT)
    SubscribableChannel einsInput();

    @Output(OUTPUT)
    MessageChannel einsOutput();

}

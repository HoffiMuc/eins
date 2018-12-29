package com.example.demo.configs;

import com.example.demo.channels.EinsProcessor;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(EinsProcessor.class)
public class StreamConfigs {

}

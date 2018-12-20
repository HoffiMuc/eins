package com.example.demo.configs;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import com.example.demo.channels.EinsProcessor;

@Configuration
@EnableBinding(EinsProcessor.class)
public class StreamConfigs {

}

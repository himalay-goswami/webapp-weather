package com.himalaya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class InitConfig {

    @Bean
    @EventListener(ContextStartedEvent.class)
    public void init(){

    }
}

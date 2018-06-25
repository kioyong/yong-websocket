package com.yong.websocket.yongwebsocket.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Configuration
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatMessageHandler(), "/websocket")
            .addInterceptors(new ParameterInterceptor())//parameter config
            .setAllowedOrigins("*");
    }

    @Bean
    public TextWebSocketHandler chatMessageHandler() {
        return new WebSocketHandler();
    }
}
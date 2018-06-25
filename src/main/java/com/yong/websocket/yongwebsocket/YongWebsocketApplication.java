package com.yong.websocket.yongwebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@EnableWebSocket
@SpringBootApplication
public class YongWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(YongWebsocketApplication.class, args);
    }
}

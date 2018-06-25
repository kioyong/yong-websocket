package com.yong.websocket.yongwebsocket.controller;

import com.yong.websocket.yongwebsocket.websocket.WebSocketHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
public class DemoController {

    @Autowired
    private WebSocketHandler wh;

    @GetMapping("/hello")
    public String helloWorld() {
        log.info("this is hello mapping!");
        log.debug("this is hello mapping!");
        return "hello World";
    }

    @GetMapping("/session/count")
    public String sessionCount() {
        int size = wh.getSessionSize();
        return "now Session count = " + size;
    }

    @GetMapping("/session/send")
    public String sendMessage() {
        log.debug("start send message");
        wh.sendMessage();
        log.debug("start send done");
        return "send message successful";
    }
}

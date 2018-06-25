package com.yong.websocket.yongwebsocket.websocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class WebSocketHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.debug("web socket connect");
        Constants.SESSIONS.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.debug("web socket disconnect");
        Constants.SESSIONS.remove(session);
    }

    public boolean sendMessage() {
        for (WebSocketSession ws : Constants.SESSIONS) {
            try {
                Map<String, Object> ab = ws.getAttributes();
                log.debug("session's attributes = {}", ab.toString());
                ws.sendMessage(new TextMessage("hello"));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public int getSessionSize() {
        return Constants.SESSIONS.size();
    }

}


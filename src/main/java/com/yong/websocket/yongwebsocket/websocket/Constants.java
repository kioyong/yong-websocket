package com.yong.websocket.yongwebsocket.websocket;

import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Constants {
    public final static List<WebSocketSession> SESSIONS = Collections.synchronizedList(new ArrayList<>());
}

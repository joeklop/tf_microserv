package com.era.socket.socket.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class SocketHandler extends TextWebSocketHandler {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        sendMessage(session, session.getLocalAddress());
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) {
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        // socketSessionPool.closeSession(session, CloseStatus.NORMAL);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    private void sendMessage(WebSocketSession session, Object object) throws IOException {
        if (session.isOpen()) {
            session.sendMessage(new TextMessage(mapper.writeValueAsString(object)));
        }
    }

}

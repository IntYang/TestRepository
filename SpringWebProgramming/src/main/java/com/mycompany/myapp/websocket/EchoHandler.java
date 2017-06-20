package com.mycompany.myapp.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class EchoHandler extends TextWebSocketHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(EchoHandler.class);
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		LOGGER.info("");
		
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception { // 메세지를 받았을 때
		LOGGER.info("");
		String strMessage = message.getPayload();
		TextMessage textMessage = new TextMessage(strMessage);
		session.sendMessage(message);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception { // 연결 끊어졌을 경우
		LOGGER.info("");
	}
	
	
}

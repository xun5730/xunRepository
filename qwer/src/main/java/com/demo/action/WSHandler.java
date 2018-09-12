package com.demo.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class WSHandler  implements WebSocketHandler{
	
	private static Logger logger=LoggerFactory.getLogger(WSHandler.class);

	@Autowired
	private WSClientManager WSClientManager;
	


	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		logger.debug("connect to the websocket success......"); 
		session.sendMessage(new TextMessage("server:connected ok!"));
		WSClientManager.setWSS.add(session);
	}

	@Override
	public void handleMessage(WebSocketSession wss, WebSocketMessage<?> wsm) throws Exception {
		
		TextMessage returnMessage=new TextMessage(wsm.getPayload()+" received at server");
		logger.debug(wss.getHandshakeHeaders().getFirst("Cookie"));
		wss.sendMessage(returnMessage);
		
	}

	@Override
	public void handleTransportError(WebSocketSession wss, Throwable t) throws Exception {
		if(wss.isOpen()){
			wss.close();
			WSClientManager.setWSS.remove(wss);
		}
	    logger.debug("websocket connection closed......");
	}
	@Override
	public void afterConnectionClosed(WebSocketSession wss, CloseStatus cs) throws Exception {

		logger.debug("websocket connection closed......"); 
		WSClientManager.setWSS.remove(wss);
	}
	@Override
	public boolean supportsPartialMessages() {
		return false;
	}

}

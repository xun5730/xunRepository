package wbsocket;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;


public class WebSocketHander1 implements WebSocketHandler {
	
	private static final Logger logger=Logger.getLogger(WebSocketHander1.class);
	private static final List<WebSocketSession> user=new ArrayList<WebSocketSession>();
	
	private String userName="";

	@Override
	public void afterConnectionClosed(WebSocketSession arg0, CloseStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	// 初次链接成功执行
	@Override
	public void afterConnectionEstablished(WebSocketSession arg0) throws Exception {
		
		logger.debug("链接成功......");
	}

	@Override
	public void handleMessage(WebSocketSession arg0, WebSocketMessage<?> arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleTransportError(WebSocketSession arg0, Throwable arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}

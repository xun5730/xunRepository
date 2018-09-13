package com.demo.action;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

//这里存放所有可用的Web socket session，用于收到Http请求后群发。
public class WSClientManager {
	
	public Set<WebSocketSession> setWSS=new HashSet<WebSocketSession>();

}

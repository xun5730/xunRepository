package com.demo.action;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.WebSocketSession;

//���������п��õ�Web socket session�������յ�Http�����Ⱥ����
public class WSClientManager {
	
	public Set<WebSocketSession> setWSS=new HashSet<WebSocketSession>();

}

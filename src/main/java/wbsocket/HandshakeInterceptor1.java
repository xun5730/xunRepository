package wbsocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
/**
 * ������
 * @author xun
 *
 */
public class HandshakeInterceptor1 implements HandshakeInterceptor {

	//�������ַ��ʺ�
	@Override
	public void afterHandshake(ServerHttpRequest arg0, ServerHttpResponse arg1, WebSocketHandler arg2, Exception arg3) {
		// TODO Auto-generated method stub
		
	}

	//�������ַ���ǰ
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse res, WebSocketHandler hander,
			Map<String, Object> map) throws Exception {
		if(request instanceof ServletServerHttpRequest){
			HttpServletRequest  servletRequest=      ((ServletServerHttpRequest)request).getServletRequest();
			String sessionId=   servletRequest.getSession().getId();//��ȡ��������sessionId
			String userName=  (String) servletRequest.getSession().getAttribute("name");
			System.out.println("��ȡsession�����name----------"+userName);
			map.put("WEBSOCKET_USERNAME", userName);
			servletRequest.getSession().setAttribute("WEBSOCKET_USERNAME", userName);
		}
		
		
		
		return true;
	}

}

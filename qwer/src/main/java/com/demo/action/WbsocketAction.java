package com.demo.action;

import java.io.IOException;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.google.gson.Gson;

public class WbsocketAction {
	
	private static Logger logger = LoggerFactory.getLogger(WbsocketAction.class);

	@Autowired
	private WSClientManager wsClientManager;
	
	@ResponseBody
	@RequestMapping(value="/testReturnJSON")
	public Object testReturnJson(@RequestParam("data")String data ){
		logger.debug("我的测试<<"+data);
		
		TextMessage toWSMsg=new TextMessage(data);
        //把收到的消息群发到WS客户端
		  Iterator<WebSocketSession> it=  wsClientManager.setWSS.iterator();
		  try {
			while(it.hasNext()){
				  WebSocketSession client=   it.next();
				  client.sendMessage(toWSMsg);
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return new Gson().toJson(data);
	}
	@RequestMapping(value="/returnModelView")
	public ModelAndView returnModelView(){
		
		ModelAndView mav=new ModelAndView();
		mav.setViewName("returnModelView");
		return mav;
		
	}
	
	
	
	
	
	
}

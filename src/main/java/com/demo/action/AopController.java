package com.demo.action;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.AopDemoService;

import designPatternDemo.动态代理Demo.MyInvocationHandler;

@Controller
@RequestMapping("/aop")
public class AopController {

	@Autowired
	private AopDemoService aopDemoService;

	
	
	
	@RequestMapping("/queryDemo11")
	@ResponseBody
	public String queryDemo11(){
		
		
		   InvocationHandler invocationHandler=new MyInvocationHandler(aopDemoService);
		   AopDemoService  service =(AopDemoService) Proxy.newProxyInstance(AopDemoService.class.getClassLoader(), aopDemoService.getClass().getInterfaces(), invocationHandler);
		   service.queryAopDemo();
		   
		return "queryDemo11";
	}
	
	
	@RequestMapping("/queryDemo")
	@ResponseBody
	public String queryDemo(Model model, HttpServletRequest request) {
		
		
		
//		String r= aopDemoService.queryAopDemo();
		String r=  aopDemoService.queryAopDemo2();
		return r;

	}

}

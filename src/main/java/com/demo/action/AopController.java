package com.demo.action;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.AopDemoService;
import com.demo.service.AsdfService;
import com.demo.service.impl.AopDemoServiceImpl;

import designPatternDemo.动态代理Demo.MyInvocationHandler;




/**
 * 
 * https://blog.csdn.net/dream_broken/article/details/72911148
 * https://www.cnblogs.com/lanhzbupt/p/6346680.html
 * https://blog.csdn.net/he90227/article/details/52388146
 *
 */
@Controller
@RequestMapping("/aop")
public class AopController {

	@Autowired
	private AopDemoService aopDemoService;

	@Autowired
	private AsdfService asdfService;
	
	
	@RequestMapping("/queryDemo22")
	@ResponseBody
	public String queryDemo22(){
		
		 aopDemoService.queryAopDemo();
		 String str= asdfService.queryCutaopDemo();
		 System.out.println(str);
		return "queryDemo22";
	}
	
	
	
	
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
	/*
	 * spring aop  事务失效的demo
	 * 
	 */

	@ResponseBody
	@RequestMapping("insertTranTest")
	public String insertTranTest(){
		User u=new User();
		u.setName("测试插入事务");
		int changeNumber= aopDemoService.insertDemo02(u);
		return "insertTranTest"+changeNumber;
		
	}
	@ResponseBody
	@RequestMapping("insertTranTest2")
	public String insertTranTest2(){
		User u=new User();
		u.setName("名字");
		int changeNumber= aopDemoService.insertDemo01(u);
		return "insertTranTest"+changeNumber;
		
	}
	
	
	
	
	
	
	
	

}

package com.demo.action;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.AopDemoService;
import com.demo.service.AsdfService;
import com.demo.service.DemoServcie;
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
	
	@Autowired
	private DemoServcie demoServcie;
	
	
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
	@RequestMapping("insertTranTest1")
	public String insertTranTest(){
		User u=new User();
		u.setName("测试插入事务");
		int changeNumber= aopDemoService.insertDemo02(u);
		return "insertTranTest"+changeNumber;
		
	}
	@ResponseBody
	@RequestMapping("insertTranTest2")
	public String insertTranTest3(){
		User u=new User();
		u.setName("测试插入事务");
		int changeNumber= aopDemoService.insertDemo03(u);
		return "insertTranTest"+changeNumber;
		
	}
	@ResponseBody
	@RequestMapping("insertTranTest3")
	public String insertTranTest4(){
		User u=new User();
		u.setName("测试插入事务");
		int changeNumber= aopDemoService.insertDemo04(u);
		return "insertTranTest"+changeNumber;
		
	}
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping("insertTranTest4")
	public String insertTranTest2(){
		User u=new User();
		u.setName("名字");
		int changeNumber= aopDemoService.insertDemo01(u);
		return "insertTranTest"+changeNumber;
		
	}
	
	@RequestMapping("queryDemo001")
	@ResponseBody
	public String queryDemo001(){
		
		String str= demoServcie.queryDemoStr();
		return str;
		
	}
	
	
	public static void main(String[] args) {
		Double dfasdf=12479.00;
		dfasdf=dfasdf*2.5;
		
		
		System.out.println(dfasdf);
		BigDecimal money =new BigDecimal("100000");
		for(int i=0;i<10;i++){
			money=money.multiply(new BigDecimal("0.03")).add(money) ; 
			System.out.println(money);
		}
		System.out.println(money);
		
		
	}
	
	
	
	
	

}

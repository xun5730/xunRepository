package com.demo.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Service;

import com.demo.service.AopDemoService;
@Service
public class AopDemoServiceImpl implements AopDemoService  {

	@Override
	public String queryAopDemo() {
		return "aopDemo";
	}

	@Override
	public String queryAopDemo2() {
//		String r= this.queryAopDemo();
		String r=  ((AopDemoService) AopContext.currentProxy()).queryAopDemo();
		return r;
	}

}

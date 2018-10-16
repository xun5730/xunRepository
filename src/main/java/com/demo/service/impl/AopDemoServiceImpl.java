package com.demo.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.OrderDao;
import com.demo.entity.User;
import com.demo.service.AopDemoService;
@Service
public class AopDemoServiceImpl implements AopDemoService  {

	
	
	@Autowired
	private OrderDao orderDao;
	
	
	@Override
	public String queryAopDemo() {
		return "aopDemo";
	}

	
	public String queryAopDemo11(){
		
		return "aopDemo2";
	}
	
	
	@Override
	public String queryAopDemo2() {
//		String r= this.queryAopDemo();
		String r=  ((AopDemoService) AopContext.currentProxy()).queryAopDemo();
		return r;
	}
	@Transactional
	public int insertDemo01(User u){
	 
		u.setName("测试事务insertDemo01");
		int changeNumber= orderDao.insertUser(u);
		int i=10/0;
		System.out.println(i);
//		throw new RuntimeException("测试插入事务");
		return changeNumber;
		
	}
	
	
	
	public int insertDemo02(User u){

		System.out.println("开始调用插入");
		int i= this.insertDemo01(u);
		System.out.println("调用插入结束");
		
		return i;
	}


	
	

}

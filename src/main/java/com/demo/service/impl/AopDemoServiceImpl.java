package com.demo.service.impl;

import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.common.SpringContextUtil;
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
	
	
	
	
	
	
	
	/**
	 * aop事务缺陷，使用this导致事务开启失败
	 * @param u
	 * @return
	 */
	public int insertDemo03(User u){
		
		System.out.println("开始调用插入");
		int i= this.insertDemo01(u);
		System.out.println("调用插入结束");
		
		return i;
	}

	/**
	 * 可以用这种方案解决aop事务 使用this导致的动态代理没有获取到的问题
	 */
	public int insertDemo02(User u){

		
		AopDemoService service=   SpringContextUtil.getBeanByClass(this.getClass());
		System.out.println("开始调用插入");
		int i= service.insertDemo01(u);
		System.out.println("调用插入结束");
		
		return i;
	}

	@Transactional
	public int insertDemo04(User u){
		
		System.out.println("开始调用插入");
		int i= this.insertDemo01(u);
		System.out.println("调用插入结束");
		
		return i;
	}
	

}

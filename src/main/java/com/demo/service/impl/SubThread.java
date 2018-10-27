package com.demo.service.impl;

import com.demo.common.SpringContextUtil;
import com.demo.service.MyJedisPubSub;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class SubThread extends Thread {

	public static MyJedisPubSub myJedisPubSub= new  MyJedisPubSub();
	
	
	@Override
	public void run() {
		
		
		JedisPool  jedisPool= SpringContextUtil.getBean("jedisPool");
		Jedis jedis=null;
	
		try {
			jedis= jedisPool.getResource();
			jedis.subscribe(myJedisPubSub, "sdemo");
			System.out.println("subscribe 阻塞结束");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(jedis!=null){
				jedis.close();
			}
		}
		
		
		
	}

	
	
	
}

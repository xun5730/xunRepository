package com.demo.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.demo.common.SpringContextUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 队列消费者
 * 
 * @author xun
 *
 */
public class RedisDemoConsumer implements Runnable {

//	static AtomicInteger timeOutCount=new AtomicInteger(2);
	
	@Override
	public void run() {

		JedisPool jedisPool = SpringContextUtil.getBean("jedisPool");
		Jedis jedis = null;
		try{
			jedis=jedisPool.getResource();
			
			while(true){
		    System.out.println("开始take queue");
			List<String> list  = jedis.blpop(100, "redisQueue1");//如果队列为空，则队列阻塞 100秒
			if(list.size()>0){
				String queueName=  list.get(0);
				String asdfJson=  list.get(1);
				System.out.println("队列名字："+queueName+"读到数据为："+asdfJson);
			}else{
				System.out.println("超过100秒没有拿到队列数据了");
			}
		
			}
		}finally{
			jedis.close();
		}
		

	}

}

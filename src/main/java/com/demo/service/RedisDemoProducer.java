package com.demo.service;

import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.demo.common.SpringContextUtil;
import com.demo.entity.Order;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redis 队列生产者
 * @author xun
 *
 */
public class RedisDemoProducer implements Runnable {

	private Map<String, Object> paramterMap;

	public Map<String, Object> getParamterMap() {
		return paramterMap;
	}

	public void setParamterMap(Map<String, Object> paramterMap) {
		this.paramterMap = paramterMap;
	}

	@Override
	public void run() {

		String flag = paramterMap.get("flag").toString();
		if (flag == null) {
			flag = "default";
		}
		// 线程里面可以注入 autowired一会尝试一下啊！
		JedisPool jedisPool = SpringContextUtil.getBean("jedisPool");
		Jedis jedis = null;

		try {
			jedis=jedisPool.getResource();
			System.out.println("开始生产数据'");
			for (int i = 0; i < 10; i++) {
				Order order = new Order();
				order.setId(new Long(i));
				order.setOrderTime(new Date());
				order.setOrderName(i + "--queue--" + flag);
				String orderJson = JSON.toJSONString(order);
				jedis.rpush("redisQueue1", orderJson);
			}
		} finally {
			jedis.close();

		}

	}

}

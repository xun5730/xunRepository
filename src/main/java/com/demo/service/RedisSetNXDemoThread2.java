package com.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.SpringContextUtil;
import com.demo.dao.AsdfDao;
import com.demo.dao.OrderDao;
import com.demo.entity.Asdf;
import com.demo.entity.Order;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisSetNXDemoThread2 implements Runnable {

	static AtomicInteger valid = new AtomicInteger(0);

	@Autowired
	private AsdfDao asdfDao;
	@Autowired
	private OrderDao orderDao;

	private Map<String, Object> paramterMap;

	public Map<String, Object> getParamterMap() {
		return paramterMap;
	}

	public void setParamterMap(Map<String, Object> paramterMap) {
		this.paramterMap = paramterMap;
	}

	@Override
	public void run() {

		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!paramterMap.containsKey("userId")) {
			return ;
		}
		this.asdfDao = SpringContextUtil.getBean("asdfDao");
		this.orderDao = SpringContextUtil.getBean("orderDao");
		JedisPool jedisPool = SpringContextUtil.getBean("jedisPool");
		Jedis jedis = null;
		try {
			System.out.println(paramterMap.get("userId").toString() +"开始执行-------------------->>>"+Thread.currentThread().getName());
			
			jedis = jedisPool.getResource();

			// 防止重复提交
			if (jedis.setnx("lockUserId" + paramterMap.get("userId").toString(),
					"lockUserId" + paramterMap.get("userId").toString()) == 1l) {
				jedis.expire("lockUserId" + paramterMap.get("userId").toString(), 10);
				// 开始业务逻辑
				/*
				 * Asdf asdf=new Asdf();
				 * asdf.setName("name"+paramterMap.get("userId").toString());
				 * asdf.setValid(timeOutCount.addAndGet(10));
				 * asdf.setValue(paramterMap.get("userId").toString());
				 * System.out.println(asdf); asdfDao.insertDemo(asdf);
				 */
				Order order2 = new Order();
				order2.setOrderTime(new Date());
				order2.setUserId(Long.parseLong(paramterMap.get("userId").toString()));
				order2.setValid(valid.getAndAdd(10));
				order2.setType(999);
				orderDao.insertOrderRecord(order2);

				resultMap.put("status", "success");
				resultMap.put("msg", valid.get() + "--success ---->" + paramterMap.get("userId").toString());

				// 结束,删除锁
				jedis.del("lockUserId" + paramterMap.get("userId").toString());

			} else {
				resultMap.put("msg", "重复提交"+paramterMap.get("userId").toString());
				resultMap.put("status", "fail");
			}

		} finally {
			jedis.close();
		}

	}

}

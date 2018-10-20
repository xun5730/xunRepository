package com.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.SpringContextUtil;
import com.demo.dao.AsdfDao;
import com.demo.dao.OrderDao;
import com.demo.entity.Asdf;
import com.demo.entity.Order;

import ch.qos.logback.core.net.SyslogOutputStream;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class ConcurrentDemoThread1 implements Callable<Map<String, Object>> {

	static ReentrantLock lock = new ReentrantLock();
	static AtomicInteger valid = new AtomicInteger(0);
//这是lock的细粒度锁的实现
//	static Map<Integer, Object> lockMap = new ConcurrentHashMap<Integer, Object>();

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
	public Map<String, Object> call() throws Exception {

		// Thread.sleep(10*1000);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		if (!paramterMap.containsKey("userId")) {
			resultMap.put("msg", "userId不存在");
			resultMap.put("status", "fail");
			return resultMap;
		}
		this.asdfDao = SpringContextUtil.getBean("asdfDao");
		this.orderDao = SpringContextUtil.getBean("orderDao");
		JedisPool jedisPool = SpringContextUtil.getBean("jedisPool");
		Jedis jedis = null;
		try {

			 lock.lock();
			Random r = new Random();
			int rid = r.nextInt(5) + 1;
//			Object lockObject = lockMap.get(rid);
//			if (lockObject == null) {
//				lockMap.put(rid, new Object());
//			}

//			synchronized (lockObject) {

				// System.out.println(paramterMap.get("userId").toString()
				// +"开始执行-------------------->>>"+Thread.currentThread().getName());

				jedis = jedisPool.getResource();

				// 防止重复提交
				if (jedis.setnx("lockUserId" + paramterMap.get("userId").toString(),
						"lockUserId" + paramterMap.get("userId").toString()) == 1l) {
					jedis.expire("lockUserId" + paramterMap.get("userId").toString(), 10);

					// order type (88为商品,1为支付,2为订单)
					Map<String, Object> map = new HashMap<String, Object>();

					map.put("id", rid);
					Asdf a = asdfDao.findAsdfById(map);// 拿到ID1剩余量
					System.out.println("剩余多少" + a.getValid());

					int nextInt = r.nextInt(10) + 1;// 打算支付金钱(数量)
					if (nextInt <= a.getValid()) {// 他可以进行投资
						Order order = new Order();// 开始支付
						order.setOrderTime(new Date());
						order.setUserId(Long.parseLong(paramterMap.get("userId").toString()));
						order.setValid(nextInt);
						order.setType(rid);
						order.setOrderName(Thread.currentThread().getName());
						orderDao.insertOrderRecord(order);// 用户支付到公司账户了。
						map.put("period", nextInt);
						int changeNumber = asdfDao.subtractValid(map);
						if (changeNumber > 0) {
							System.out.println("投资成功");
							Order order2 = new Order();// 保存用户订单
							order2.setOrderTime(new Date());
							order2.setUserId(Long.parseLong(paramterMap.get("userId").toString()));
							order.setValid(nextInt);
							order.setType(rid);
							order.setOrderName(Thread.currentThread().getName());
							orderDao.insertOrderRecord2(order);
						}
						resultMap.put("status", "success");
						resultMap.put("msg", Thread.currentThread().getName() + "用户"
								+ paramterMap.get("userId").toString() + "买了" + nextInt);

					} else {// 剩余金额已经不足了
						resultMap.put("status", "fail");
						resultMap.put("msg", "剩余可投资金额不足,商品没有足够的数量");

					}
					// 结束,删除锁
					jedis.del("lockUserId" + paramterMap.get("userId").toString());
					return resultMap;

				} else {
					resultMap.put("msg", "重复提交" + paramterMap.get("userId").toString());
					resultMap.put("status", "fail");
					return resultMap;
				}
//			}

		} finally {
			lock.unlock();
			jedis.close();
		}

	}

}

package com.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AsdfDao;
import com.demo.entity.Asdf;

@Service
@Transactional
public class RedisDemoService {

	@Autowired
	private AsdfDao asdfDao;
	
	
	public void redisSetNX() throws Exception {

//		ExecutorService es = Executors.newCachedThreadPool();
//		ExecutorService es=    Executors.newFixedThreadPool(10);
		
//		ExecutorService es= Executors.newSingleThreadExecutor();
//		ExecutorService es= Executors.newScheduledThreadPool(10);                                      
		ThreadPoolExecutor es=new ThreadPoolExecutor(10, 10,200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(40));
		

		List<Future> futureTaskList = new ArrayList<Future>();
		
		
		for (int i = 1; i <= 50; i++) {
			RedisSetNXDemo redisSetNXDemo = new RedisSetNXDemo();
			Map<String, Object> paramterMap = new HashMap<String, Object>();
			paramterMap.put("userId", 100);
			redisSetNXDemo.setParamterMap(paramterMap);
			Future future =es.submit(redisSetNXDemo);
			futureTaskList.add(future);

		}
		
//		Thread.sleep(1000);
/*		for (int i = 1; i <= 10; i++) {
			RedisSetNXDemo redisSetNXDemo = new RedisSetNXDemo();
			Map<String, Object> paramterMap = new HashMap<String, Object>();
			paramterMap.put("userId", 20);
			redisSetNXDemo.setParamterMap(paramterMap);
			Future future =es.submit(redisSetNXDemo);
			futureTaskList.add(future);

		}
		for (int i = 1; i <= 20; i++) {
			RedisSetNXDemo redisSetNXDemo = new RedisSetNXDemo();
			Map<String, Object> paramterMap = new HashMap<String, Object>();
			paramterMap.put("userId", 100);
			redisSetNXDemo.setParamterMap(paramterMap);
			Future future =es.submit(redisSetNXDemo);
			futureTaskList.add(future);

		}*/

		es.shutdown();
		Thread.sleep(5000);
		
		for (Future future : futureTaskList) {
			Map<String, Object> resultMap = (Map<String, Object>) future.get();
			System.out.println(resultMap.get("status") + "------" + resultMap.get("msg"));
		}
	}

	public void demo() {
		
	      Asdf asdf=new Asdf();
		 asdf.setName("name");
		 asdf.setValid(1);
		 asdf.setValue("value");
		 System.out.println(asdf);
		 asdfDao.insertDemo(asdf);
		 
		
		
		
	}

}

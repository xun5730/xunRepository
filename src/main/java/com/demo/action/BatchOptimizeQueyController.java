package com.demo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.InsertUserThreadDemo;
import com.demo.service.OrderService;

import redis.clients.jedis.Jedis;


/**
 *
 * 
 * 模拟面试200万条数据怎么用redis模仿
 * 
 * @author xun
 *
 */
@Controller
@RequestMapping("/optimizeQuey")
public class BatchOptimizeQueyController {

	
	
	
	
	
	@Autowired
	private OrderService orderService;
	/**准备插入
	 * 二百万条数据插入完成
	 * @return
	 */
	@RequestMapping("/insertBathTwoMillionPrepare")
	@ResponseBody
	public String insertBathTwoMillionPrepare(){
		orderService.batchUserDemo();
		
		return "二百万条数据插入完成";
		
	}
	
	/**
	 * 批量插入
	 * @return
	 */
	@RequestMapping("/multiThreadInsertDemo")
	@ResponseBody
	public String multiThreadInsertDemo(){
		
		long s= System.currentTimeMillis();
		List<User> listData=new ArrayList<User>();
	/*	Random r=new Random();
		for (int i = 1; i <= 10000; i++) {
			User user=new User();
			user.setId(i);
			user.setInfo("info"+i);
			user.setName("name"+i);
			int score= r.nextInt(1000);
			user.setScore(score);
			listData.add(user);
	    }*/
		int batchCount=1000000;
		
		for(int i=1;i<=batchCount;i++){
			User u=new User();
			u.setName("name"+i);
			u.setInfo("这是第"+i+"条数据");
			u.setScore(0);
			listData.add(u);
		}
		
		
		
		long e= System.currentTimeMillis();
		System.out.println("线程池调用结束---------------->"+(e-s));	
		long startTime= System.currentTimeMillis();
		
		
		    	/**
				 * 这里想突然测试一下ArrayList 和linkedList效率
				 */
				int threadCount = 10000;//一个线程处理10000条数据
				int listSize = listData.size();//数据集合大小
				int runSize = Runtime.getRuntime().availableProcessors();   //开启的线程数(根据cpu获取线程数)
				System.out.println("开启线程数量"+runSize);
				int loop= (int) Math.ceil( listSize/(double)threadCount);
				List<User> tempList=new ArrayList<User>(threadCount);
				int start,stop;
				List<InsertUserThreadDemo> threadList=new ArrayList<InsertUserThreadDemo>();
				for(int i=0;i<loop;i++){
					tempList.clear();
					start=i*threadCount;
					stop= Math.min(i*threadCount+threadCount-1, listSize-1);
					System.out.println("范围"+i+":----->"+start+"----"+stop);
					for(int j=start;j<=stop;j++){
//						System.out.println( j+"-----------"+ listData.get(j));
						tempList.add(listData.get(j));
					}
					InsertUserThreadDemo insertUserThreadDemo=new InsertUserThreadDemo( );
					insertUserThreadDemo.setList(tempList);
					threadList.add(insertUserThreadDemo);
					
				}
				ExecutorService executor = Executors.newFixedThreadPool(runSize);
				
				for(InsertUserThreadDemo d:threadList  ){
					executor.execute(d);
				}
			
				
				
				
				
				executor.shutdown();
			while(!executor.isShutdown()){
				System.out.println("还在插入中");
			}
				
			long endTime= System.currentTimeMillis();
//			Long time= endTime-startTime;
			System.out.println("线程池调用结束"+(endTime-startTime));	
		
	
//		System.out.println("线程池调用结束"+(endTime-startTime));
		return "multiThreadInsertDemo";
		
	}
	
	
	
	

}

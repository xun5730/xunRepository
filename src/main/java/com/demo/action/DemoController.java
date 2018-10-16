package com.demo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.service.ConcurrentDemoThread1;
import com.demo.service.OrderService;

@RequestMapping("/concurrentDemo")
@Controller
public class DemoController {

	@Autowired
	private OrderService orderService;
	
	
	
	/**
	 * concurrentDemo 
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/demo1")
	@ResponseBody
	public String concurrentDemo1() throws Exception{
		
		    
		   
		    
		   
		    
		    
		    
		    ExecutorService es=   Executors.newFixedThreadPool(10);
		    long start=System.currentTimeMillis();
		    Map<String,Object> parameterMap=null;
		    List<Future> list=new ArrayList<Future>();
		    for(int i=1;i<200;i++){
		    	 parameterMap=new HashMap<String,Object>();
		    	 parameterMap.put("userId", i);
		    	 ConcurrentDemoThread1 concurrentDemoThread1=new ConcurrentDemoThread1();
		    	 concurrentDemoThread1.setParamterMap(parameterMap);
		    	 Future  future= es.submit(concurrentDemoThread1);
		    	 list.add(future);
		    }
		    Map<String,Object> resultMap=null;
		    for(Future future :list){
		    	
		    	 resultMap= (Map<String, Object>) future.get();
		    	 System.out.println(resultMap.get("status")+"-----<<<>>>>"+resultMap.get("msg"));
		    }
		    
		    long end=System.currentTimeMillis();
		    
		    System.out.println("用时  "+(end-start));
		    es.shutdown();
//		    FutureTask  ft=new FutureTask(concurrentDemoThread1);
		    
//		    Thread t=new Thread(ft);
//		    t.start();
		    
//		    Map<String,Object> resultMap=  (Map<String, Object>) ft.get();
		    
//		    System.out.println(resultMap.get("status")+"-----<<<>>>>"+resultMap.get("msg"));
		    
		    
		
		return "demo1";
	}
	@RequestMapping("/batchDemo")
	public String batchDataDemo(){
		
		orderService.batchDataDemo();
		
		return "batchDemos";
		
	}
	@RequestMapping("/insertUser")
	public String insertUser(){
		User u=new User();
		u.setName("nameDemo");
		u.setInfo("这是一个demo数据");
		int changeNumber=  orderService.insertUser(u);
		
		if(changeNumber>0){
			System.out.println("user插入数据成功");
		}
		return "inserUserDemo";
	}
	
	@RequestMapping("/batchUserDemo")
	@ResponseBody
	public String batchUserDemo(){
		orderService.batchUserDemo();
		return "batchUserDemo";
		
	}
	
	
	
	public String batchDataVoucherDemo(){
		
		orderService.batchVoucherDemo();
		
		return "batchVoucher";
	}
	
	
	
	
}

package com.demo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.SerializeUtil;
import com.demo.entity.Asdf;
import com.demo.service.RedisDemoConsumer;
import com.demo.service.RedisDemoProducer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Controller
@RequestMapping("redisDemo")
public class RedisController {
	//设置redis密码
//	CONFIG SET requirepass "123456"
	@Autowired
	private JedisPool jedisPool;
	
	@RequestMapping("/demo1")
	@ResponseBody
	public String demo1(){
		Jedis jedis= jedisPool.getResource();
		jedis.set("1234","asdf");
		jedis.close();
		
		return "1234";
	}
	/**
	 * redis  setString 序列化方式 10W 条数据
	 * 
	 * redis存取100万条数据测试
		生成10W条数据用了：235
		redis写入10W条数据用了：2602
		redis获取10W条数据用了：1471
		okokokokokokok
	 * 
	 */
	@RequestMapping("/demo2")
	public void demo2(){

		Jedis jedis= jedisPool.getResource();
		System.out.println("redis存取100万条数据测试");
        long start1 = System.currentTimeMillis();
		List<Asdf> listAsdf1=new ArrayList<Asdf>();
		for(int i=0;i<1000000;i++){
			Asdf asdf=new Asdf();
			asdf.setId(i);
			asdf.setName(i+"name");
			listAsdf1.add(asdf);
		}
		long start2 = System.currentTimeMillis();
		System.out.println("生成100W条数据用了："+(start2-start1));
		jedis.set("10WList1".getBytes(), SerializeUtil.serialize(listAsdf1));
		long start3 = System.currentTimeMillis();
		System.out.println("redis写入100W条数据用了："+(start3-start2));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long start4 = System.currentTimeMillis();
		byte[] in1=   jedis.get("10WList1".getBytes());
		List<Asdf>  takelistAsdf1= SerializeUtil.unserializeForList(in1);
		long start5 = System.currentTimeMillis();
		System.out.println("redis获取100W条数据用了："+(start5-start4));
		System.out.println("okokokokokokok");
		jedis.close();
/*		for(Asdf asdf:takelistAsdf1){
			System.out.println(asdf.getId());
		}
		long start6 = System.currentTimeMillis();
		System.out.println("便利redis获取10W条数据用了："+(start6-start5));*/
		
		
		
		
		
	}
	/**
	 * redis 10W 数据   JSON方式
	 * 
	 * redis存取10万条数据测试
生成10W条数据用了：228
redis写入10W条数据用了：1521
redis获取10W条数据用了：1020
okokokokokokok
我觉着用fastJSON会更快
	 */
	@RequestMapping("/demo3")
	public void demo3(){
		
		Jedis jedis= jedisPool.getResource();
		System.out.println("redis存取100万条数据测试");
        long start1 = System.currentTimeMillis();
		List<Asdf> listAsdf1=new ArrayList<Asdf>();
		for(int i=0;i<1000000;i++){
			Asdf asdf=new Asdf();
			asdf.setId(i);
			asdf.setName(i+"name");
			listAsdf1.add(asdf);
		}
		long start2 = System.currentTimeMillis();
		System.out.println("生成100W条数据用了："+(start2-start1));
		
	
		Gson gson=new Gson();
		String listAsdf1Str=   gson.toJson(listAsdf1);
		jedis.set("10WList1JsonStr", listAsdf1Str);
	
		long start3 = System.currentTimeMillis();
		System.out.println("redis写入100W条数据用了："+(start3-start2));
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long start4 = System.currentTimeMillis();
		String takeListAsdf1Str =   jedis.get("10WList1JsonStr");
		List<Asdf> takeList = gson.fromJson(takeListAsdf1Str, new TypeToken<List<Asdf>>(){}.getType());  
		long start5 = System.currentTimeMillis();
		System.out.println("redis获取100W条数据用了："+(start5-start4));
//		System.out.println(takeList);
		System.out.println("okokokokokokok");
		
	}
	
	
	
	@RequestMapping("/redisQueueDemoProducer")
	@ResponseBody
	public String redisQueueDemoProducer (String flag){
	
		RedisDemoProducer  rp=new RedisDemoProducer();
		Map<String,Object> patamterMap=new HashMap<String,Object>();
		patamterMap.put("flag", flag);
		rp.setParamterMap(patamterMap);
		//启动redis queue
		new Thread(rp).start(); 
		return "redisDemoProducerStart"+flag;
	 }
	
	@RequestMapping("/redisQueueDemoConsumer")
	@ResponseBody
	public String redisQueueDemoConsumer(){
		
		
		RedisDemoConsumer rc=new RedisDemoConsumer();
		new Thread(rc).start();
		
		return "redisDemoConsumer";
	}
	
	@RequestMapping("/redisBlpopTimeOutDemo")
	@ResponseBody
	public String redisBlpopTimeOutDemo(){
		Jedis jedis= jedisPool.getResource();
		List<String> list  = jedis.blpop(5, "redisQueue1");
		System.out.println(list.size());
		jedis.close();
		return "redisBlpopTimeOutDemo";
	}
	
	
	
	
	
	public static void main(String[] args) {
		

	/*	Asdf e=new Asdf();
		List<Asdf> list=new ArrayList<Asdf>();
		for(int i=0;i<3;i++){
			e.setId(i);
			e.setName(i+"name");
			list.add(e);
		}
		
		Asdf e2= list.get(0);
		e2.setId(999);
		e2.setName("asdf");
		for(Asdf asdf:list){
			System.out.println(asdf.getId()+"---"+asdf.getName());
		}*/
		
		
		List<Asdf> list=new ArrayList<Asdf>();
		for(int i=0;i<3;i++){
			Asdf e=new Asdf();
			e.setId(i);
			e.setName(i+"name");
			list.add(e);
		}
		Gson gson=new Gson();
		String str= gson.toJson(list);
//		List<Asdf> takeList=  gson.fromJson(str, Asdf.class);
		List<Asdf> takeList = gson.fromJson(str, new TypeToken<List<Asdf>>(){}.getType());  
		for(Asdf asdf:takeList){
			System.out.println(asdf.getId());
		}
		
	}
	
	

}

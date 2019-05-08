package com.demo.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.autogenerationXml.dao.UserMapper;
import com.demo.common.SerializeUtil;
import com.demo.dao.OrderDao;
import com.demo.entity.Asdf;
import com.demo.entity.User;
import com.demo.entity.UserCriteria;
import com.demo.service.InsertUserThreadDemo;
import com.demo.service.MyJedisPubSub;
import com.demo.service.OrderService;
import com.demo.service.RedisDemoConsumer;
import com.demo.service.RedisDemoProducer;
import com.demo.service.RedisDemoService;
import com.demo.service.RedisSetNXDemo;
import com.demo.service.impl.SubThread;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import ch.qos.logback.core.net.SyslogOutputStream;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

@Controller
@RequestMapping("redisDemo")
public class RedisController {
	private static MyJedisPubSub myJedisPubSub=new MyJedisPubSub();
	// 设置redis密码
	// CONFIG SET requirepass "123456"
	@Autowired
	private JedisPool jedisPool;
	
	@Autowired
	private RedisDemoService redisDemoService;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderDao orderDao;

	@RequestMapping("/demo1")
	@ResponseBody
	public String demo1() {
		Jedis jedis = jedisPool.getResource();
		jedis.set("1234", "asdf");
		jedis.close();

		return "1234";
	}

	/**
	 * redis setString 序列化方式 10W 条数据
	 * 
	 * redis存取100万条数据测试 生成10W条数据用了：235 redis写入10W条数据用了：2602 redis获取10W条数据用了：1471
	 * okokokokokokok
	 * 
	 */
	@RequestMapping("/demo2")
	public void demo2() {

		Jedis jedis = jedisPool.getResource();
		System.out.println("redis存取100万条数据测试");
		long start1 = System.currentTimeMillis();
		List<Asdf> listAsdf1 = new ArrayList<Asdf>();
		for (int i = 0; i < 1000000; i++) {
			Asdf asdf = new Asdf();
			asdf.setId(i);
			asdf.setName(i + "name");
			listAsdf1.add(asdf);
		}
		long start2 = System.currentTimeMillis();
		System.out.println("生成100W条数据用了：" + (start2 - start1));
		jedis.set("10WList1".getBytes(), SerializeUtil.serialize(listAsdf1));
		long start3 = System.currentTimeMillis();
		System.out.println("redis写入100W条数据用了：" + (start3 - start2));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long start4 = System.currentTimeMillis();
		byte[] in1 = jedis.get("10WList1".getBytes());
		List<Asdf> takelistAsdf1 = SerializeUtil.unserializeForList(in1);
		long start5 = System.currentTimeMillis();
		System.out.println("redis获取100W条数据用了：" + (start5 - start4));
		System.out.println("okokokokokokok");
		jedis.close();
		/*
		 * for(Asdf asdf:takelistAsdf1){ System.out.println(asdf.getId()); }
		 * long start6 = System.currentTimeMillis();
		 * System.out.println("便利redis获取10W条数据用了："+(start6-start5));
		 */

	}

	/**
	 * redis 10W 数据 JSON方式
	 * 
	 * redis存取10万条数据测试 生成10W条数据用了：228 redis写入10W条数据用了：1521 redis获取10W条数据用了：1020
	 * okokokokokokok 我觉着用fastJSON会更快
	 */
	@RequestMapping("/demo3")
	public void demo3() {

		Jedis jedis = jedisPool.getResource();
		System.out.println("redis存取100万条数据测试");
		long start1 = System.currentTimeMillis();
		List<Asdf> listAsdf1 = new ArrayList<Asdf>();
		for (int i = 0; i < 1000000; i++) {
			Asdf asdf = new Asdf();
			asdf.setId(i);
			asdf.setName(i + "name");
			listAsdf1.add(asdf);
		}
		long start2 = System.currentTimeMillis();
		System.out.println("生成100W条数据用了：" + (start2 - start1));

		Gson gson = new Gson();
		String listAsdf1Str = gson.toJson(listAsdf1);
		jedis.set("10WList1JsonStr", listAsdf1Str);

		long start3 = System.currentTimeMillis();
		System.out.println("redis写入100W条数据用了：" + (start3 - start2));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long start4 = System.currentTimeMillis();
		String takeListAsdf1Str = jedis.get("10WList1JsonStr");
		List<Asdf> takeList = gson.fromJson(takeListAsdf1Str, new TypeToken<List<Asdf>>() {
		}.getType());
		long start5 = System.currentTimeMillis();
		System.out.println("redis获取100W条数据用了：" + (start5 - start4));
		// System.out.println(takeList);
		System.out.println("okokokokokokok");

	}

	@RequestMapping("/redisQueueDemoProducer")
	@ResponseBody
	public String redisQueueDemoProducer(String flag) {

		RedisDemoProducer rp = new RedisDemoProducer();
		Map<String, Object> patamterMap = new HashMap<String, Object>();
		patamterMap.put("flag", flag);
		rp.setParamterMap(patamterMap);
		// 启动redis queue
		new Thread(rp).start();
		return "redisDemoProducerStart" + flag;
	}

	@RequestMapping("/redisQueueDemoConsumer")
	@ResponseBody
	public String redisQueueDemoConsumer() {

		RedisDemoConsumer rc = new RedisDemoConsumer();
		new Thread(rc).start();

		return "redisDemoConsumer";
	}

	@RequestMapping("/redisBlpopTimeOutDemo")
	@ResponseBody
	public String redisBlpopTimeOutDemo() {
		Jedis jedis = jedisPool.getResource();
		List<String> list = jedis.blpop(5, "redisQueue1");
		System.out.println(list.size());
		jedis.close();
		return "redisBlpopTimeOutDemo";
	}

	/**
	 * redis setNX防止重复提交的例子
	 * 
	 * 
	 * @return
	 * @throws Exception 
	 * @throws InterruptedException 
	 */
	@RequestMapping("/redisSetNX")
	@ResponseBody
	public String redisSetNX() throws InterruptedException, Exception {
/*
		ExecutorService es = Executors.newCachedThreadPool();
		
		
		List<Future> futureTaskList=new ArrayList<Future>();
		for(int i=1;i<=30;i++){
			RedisSetNXDemo redisSetNXDemo=new RedisSetNXDemo();
			Map<String,Object> paramterMap=new HashMap<String,Object>();
			paramterMap.put("userId", i);
			redisSetNXDemo.setParamterMap(paramterMap);
			FutureTask<Map<String,Object>> futureTask=new FutureTask<Map<String,Object>>(redisSetNXDemo);
			Future future=  es.submit(futureTask);
			futureTaskList.add(future);
		}
		
		
		
		
//		Map<String,Object> dfs=  (Map<String, Object>) es.submit(redisSetNXDemo);
		for(Future future:futureTaskList){
			Map<String,Object> resultMap=    (Map<String, Object>) future.get();
			System.out.println(resultMap.get("status")+"------"+resultMap.get("msg"));
		}
		
		*/

	    redisDemoService.redisSetNX();
		
		
		
		return "redisSETNXdemo";
	}
	@RequestMapping("/demo")
	@ResponseBody
	public String demo(){
		
		redisDemoService.demo();
		
		return "demo";
	}

	/**
	 * 批量插入
	 * @return
	 */
	@RequestMapping("/multiThreadInsertDemo")
	@ResponseBody
	public String multiThreadInsertDemo(){
		
		
		List<User> listData=new ArrayList<User>();
		Random r=new Random();
		for (int i = 1; i <= 1000000; i++) {
			User user=new User();
			user.setId(i);
			user.setInfo("info"+i);
			user.setName("name"+i);
			int score= r.nextInt(1000);
			user.setScore(score);
			listData.add(user);
	    }
		long startTime= System.currentTimeMillis();
		
		
		    	/**
				 * 这里想突然测试一下ArrayList 和linkedList效率
				 */
				int threadCount = 1000;//一个线程处理10000条数据
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
			while(executor.isShutdown()){
				long endTime= System.currentTimeMillis();
				Long time= endTime-startTime;
				System.out.println("线程池调用结束"+(endTime-startTime));
				try {
					Jedis jedis = jedisPool.getResource();
					jedis.set("m", time.toString());
					jedis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
				
				
		
	
//		System.out.println("线程池调用结束"+(endTime-startTime));
		return "multiThreadInsertDemo";
		
	}
	
	/**
	 * 一次性全部插入
	 * @return
	 */
	@RequestMapping("/insertBatchUserDemo2")
	@ResponseBody
	public String insertBatchUserDemo2(){
		
		List<User> listData=new ArrayList<User>();
		Random r=new Random();
		for (int i = 1; i <= 100000; i++) {
			User user=new User();
			user.setId(i);
			user.setInfo("info"+i);
			user.setName("name"+i);
			int score= r.nextInt(1000);
			user.setScore(score);
			listData.add(user);
	    }
		long startTime= System.currentTimeMillis();
		int changeNumber= orderService.batchUserDemo(listData);
		long endTime= System.currentTimeMillis();
		System.out.println("已经插入数据量为"+changeNumber+"--时间为"+(endTime-startTime));
		return "insertBatchUserDemo2";
	}
	
	
	
	@RequestMapping("redisZSetDemoInsertUser")
	@ResponseBody
	public String redisZSetDemoUserSocre(){
	
		Gson gson=new Gson();
		UserCriteria  userExample=new UserCriteria();
		UserCriteria.Criteria c=  userExample.createCriteria();
		c.andScoreIsNotNull();
		List<User> list= userMapper.selectByExample(userExample);
		System.out.println(list.size());
		Jedis jedis = jedisPool.getResource();
		for(User user:list){
			jedis.zadd("userZSet" ,new Double( user.getScore()),gson.toJson(user));	
		}
		jedis.close();
		
		return "list 的size"+list.size();
	}
	@RequestMapping("redisZSetDemoGetUser")
	@ResponseBody
	public String redisZSetDemoGetUser(){
		
		Jedis jedis = jedisPool.getResource();
		Set<String>  setStr= jedis.zrange("userZSet", 0, -1);
		for(String str:setStr){
			System.out.println(str);
		}
		jedis.close();
		
		return "zsetDemo";
	}
	/**
	 * redis发布订阅的demo并不满意，不是很会用。觉着。。。
	 * @return
	 */
	@RequestMapping("redisSubscribeDemo")
	@ResponseBody
	public String redisSubscribeDemo(){
		
		
		SubThread st=new SubThread();
		st.start();
		
		return "redisSubscribe";
	}
	/**
	 * 取消订阅
	 * @return
	 */
	@RequestMapping("redisUNSubscribeDemo")
	@ResponseBody
	public String redisUNSubscribeDemo(){
		SubThread.myJedisPubSub.unsubscribe("sdemo");
		return "UNSub";
	}
	
	
	
	@RequestMapping("redisPulishSubscribeDemo")
	@ResponseBody
	public String  redisPulishSubscribeDemo(String pulish){
		
		if(pulish==null){
			pulish="demo";
		}
		Jedis jedis = jedisPool.getResource();
		Long acceptNum= jedis.publish("sdemo", pulish);
		System.out.println("接受数量"+acceptNum);
		jedis.close();
		return "pulish:"+pulish;
	}
	
	
	
	
	
	
	

	
	
	
	
	

	public static void main(String[] args) {

		/*
		 * Asdf e=new Asdf(); List<Asdf> list=new ArrayList<Asdf>(); for(int
		 * i=0;i<3;i++){ e.setId(i); e.setName(i+"name"); list.add(e); }
		 * 
		 * Asdf e2= list.get(0); e2.setId(999); e2.setName("asdf"); for(Asdf
		 * asdf:list){ System.out.println(asdf.getId()+"---"+asdf.getName()); }
		 */

		/*
		 * GSON 解析 list<实体类> 和反解析
		 * List<Asdf> list = new ArrayList<Asdf>();
		for (int i = 0; i < 3; i++) {
			Asdf e = new Asdf();
			e.setId(i);
			e.setName(i + "name");
			list.add(e);
		}
		Gson gson = new Gson();
		String str = gson.toJson(list);
		// List<Asdf> takeList= gson.fromJson(str, Asdf.class);
		List<Asdf> takeList = gson.fromJson(str, new TypeToken<List<Asdf>>() {
		}.getType());
		for (Asdf asdf : takeList) {
			System.out.println(asdf.getId());
		}*/
		
		
	/*	int i=1;
		while(i>0){
			break;
		}
	   System.out.println("你好");*/
		
		
		
		
		/**
		 * 如何好好的截取
		 */
		int size=45;
		
		int count=10;
		int c=(int) Math.ceil(size/count);
		
		
		for(int i=0;i<=c;i++){
		
			
		 int s=i*count;	
		 int loop=	Math.min(i*count +count-1  , size-1);
			
			System.out.println("截取："+i+"  从"+s+"-----"+loop  );
			
		}
		
		
		
		
		
	   
	   
		

	}
	
	
	
	
	
	
	
	

}

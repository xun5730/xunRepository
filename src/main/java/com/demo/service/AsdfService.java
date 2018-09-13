package com.demo.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.AsdfDao;
import com.demo.dao.OrderDao;
import com.demo.entity.Asdf;
import com.demo.entity.Order;

@Service
@Transactional
public class AsdfService  {
	
	public static int i=0;
	
	

	@Autowired
	private AsdfDao asdfDao;
	
	@Autowired
	private OrderDao orderDao;


	public String queryCutaopDemo() {
		
		return "queryCutaopDemo";
	}
	public String queryAopDemo(){
		return "aopDemo";
	}
	
	public String queryAopDemo2() {
		 String asdf= this.queryAopDemo();
		 System.out.println("queryDemo2"+asdf);
		return "demo2";
	}
	public List<Asdf> findAsdf() {
		return asdfDao.findAsdf();
	}

	
	public Integer insertAopDemo() {

		Asdf a = new Asdf();

		a.setName("nvvv");
		a.setValue("vvv");
		int i = 1 / 0;
		// throw new RuntimeException("会滚吧");

		return asdfDao.insertAopDemo(a);
	}

	public Asdf findAsdfById(String id) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);

		return asdfDao.findAsdfById(map);
	}

	public Map<String,Object> c1() {
		
		Map<String,Object> resultMap=new HashMap<String,Object>();
		
		String id = "1";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Asdf a= asdfDao.findAsdfById(map);//拿到ID1剩余量
		System.out.println( "剩余多少"+ a.getValid());
		Random r = new Random();
		int nextInt = r.nextInt(10);
		map.put("period", nextInt);
		
		if(nextInt<=a.getValid()){
			int changeNumber=asdfDao.subtractValid(map);
			if(changeNumber>0){
				resultMap.put("status", "success");
				resultMap.put("data", nextInt);
				resultMap.put("msg", "抢购成功");
				return resultMap;
				
			}else{
				resultMap.put("status", "fail");
				resultMap.put("data", nextInt);
				resultMap.put("msg", "抢购失败");
				return resultMap;
			}
		}else{
			resultMap.put("status", "fail");
			resultMap.put("msg", "已经没有了");
			return resultMap;
		}

	}

	public  Integer plusValidSetPeriod() {
		
//		synchronized (AsdfService.class) {
		String id = "4";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Asdf a= asdfDao.findAsdfById(map);//拿到ID4剩余量
		System.out.println( "当前多少"+ a.getValid());
		    a.getValid();
		    int period=a.getValid()+1;
		    map.put("period", period);
		    map.put("id", id);
		   asdfDao.plusValidSetPeriod(map);
		   return period;
//		}
	}
	public void plusValidSetPeriodForUpdate() {
		String id = "4";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Asdf a= asdfDao.findAsdfByIdForUpdate(map);//拿到ID4剩余量
		System.out.println( "当前多少"+ a.getValid());
		a.getValid();
		int period=a.getValid()+1;
		map.put("period", period);
	    map.put("id", id);
		asdfDao.plusValidSetPeriod(map);
		
	}
	public  void autoIncrement() {
		
		synchronized (AsdfService.class) {
	            i=i+1;
	            
		}
	}
	
	
	public void plusValidAddPeriod() {
			String id = "5";
			Map<String, Object> map = new HashMap<String, Object>();
			Asdf a= asdfDao.findAsdfById(map);//拿到ID1剩余量
			map.put("period", 1);
			map.put("id", id);
			asdfDao.plusValidAddPeriod(map);
			
		
		}

	public synchronized  void investLoan() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "5");
		Asdf a= asdfDao.findAsdfById(map);//拿到ID1剩余量
		System.out.println( "剩余多少"+ a.getValid());
		Random r=new Random();
		 int nextInt=   r.nextInt(10)+1;//打算支付金钱
		if(nextInt<=a.getValid()){//他可以进行投资
			
			Order order=new Order();//开始支付
			order.setOrderTime(new Date());
			order.setUserId(Thread.currentThread().getId());
			order.setValid(nextInt);
			order.setType(1);
			orderDao.insertOrderRecord(order);//用户支付到公司账户了。
			System.out.println("支付成功");
			map.put("period", nextInt);
			int changeNumber=asdfDao.subtractValid(map);
			if(changeNumber>0){
				System.out.println("投资成功");
				Order order2=new Order();//保存用户订单
				order2.setOrderTime(new Date());
				order2.setUserId(Thread.currentThread().getId());
				order.setValid(nextInt);
				order.setType(2);
				orderDao.insertOrderRecord(order);
			}
			
		}else{//剩余金额已经不足了
			System.out.println("剩余可投资金额不足");
		} 
		
		
		
		
	}
	
	public void  getRandomTest(BigDecimal investMoney,Long userId){
		
		Order order=new Order();
		order.setOrderTime(new Date());
		order.setUserId(userId);
		order.setValid(0);
		order.setType(1);
		orderDao.insertOrderRecord(order);
		ExecutorService es=  Executors.newFixedThreadPool(3); 
	
		RandomThreadPlate  rtdfap=new RandomThreadPlate();
		Map<String,Object> paramMap =new HashMap<String,Object>();
		paramMap.put("investMoney", investMoney);
		paramMap.put("userId", userId);
		rtdfap.setParamsMap(paramMap);
		es.execute(rtdfap);
	}
	public static void main(String[] args) {
		
		
	}



	

	
}

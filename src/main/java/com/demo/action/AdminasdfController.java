package com.demo.action;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Asdf;
import com.demo.service.AsdfService;
import com.google.gson.Gson;



@Controller
@RequestMapping(value = "/demo")
public class AdminasdfController {
	
	private BlockingQueue<Asdf> queue=new LinkedBlockingQueue<Asdf>();
	
	static{
		System.out.println("11111111");
	}
	@Autowired
	private AsdfService asdfService;
	
	
	@RequestMapping("/queryAopDemo")
	public String index(Model model, HttpServletRequest request){
		
		/*System.out.println("index");
		String sdfs1= asdfService.queryAopDemo();
		System.out.println(sdfs1);*/
		String sdfs2= asdfService.queryAopDemo2();
		System.out.println(sdfs2);
		return "/index";
		
	}
	@RequestMapping("/c1")
	@ResponseBody
	public String qiangcurrentDemo(Model model, HttpServletRequest request){
		
		Map<String,Object> map=    asdfService.c1();
		return new Gson().toJson(map);
		
	}
	
	@RequestMapping("/noSynInsert1")
	@ResponseBody
	public String plusValidSetPeriod(Model model, HttpServletRequest request){
		
		   asdfService.plusValidSetPeriod();
		return "ok";
		
	}
	@RequestMapping("/noSynInsert2")
	@ResponseBody
	public String plusValidAddPeriod(Model model, HttpServletRequest request){
		
	   asdfService.plusValidAddPeriod();
		return "ok";
		
	}
	/**
	 * 开始大量求情
	 * @throws InterruptedException 
	 */
	@RequestMapping("/manyRequest")
	@ResponseBody
	public String manyRequest() throws InterruptedException{
		Long timeStart=  System.currentTimeMillis();
		 int count = 1000;
	        List<Thread> workers = new ArrayList<Thread>();
	        for(int i = 0; i < count; i++) {
	            Thread worker = new Thread(new Runnable() {
	                public void run() {
	                	asdfService.plusValidSetPeriod();
	                }
	            });
	            worker.start();
	            workers.add(worker);
	        }
	        for(int i = 0; i < count; i++) {
	            workers.get(i).join();
	        }
	        Long timeEnd=  System.currentTimeMillis();
	        Long timeRun=timeEnd-timeStart;
	        System.out.println("请求全部完毕,执行主线程"+timeRun);
	        
	        return "ok";
	}
	@RequestMapping("/manyRequestForUpdate")
	@ResponseBody
	public String manyRequestForUpdate() throws InterruptedException{
		Long timeStart=  System.currentTimeMillis();
		 int count = 1000;
	        List<Thread> workers = new ArrayList<Thread>();
	        for(int i = 0; i < count; i++) {
	            Thread worker = new Thread(new Runnable() {
	                public void run() {
	                	asdfService.plusValidSetPeriodForUpdate();
	                }
	            });
	            worker.start();
	            workers.add(worker);
	        }
	        for(int i = 0; i < count; i++) {
	            workers.get(i).join();
	        }
	        Long timeEnd=  System.currentTimeMillis();
	        Long timeRun=timeEnd-timeStart;
	        System.out.println("请求全部完毕,执行主线程"+timeRun);
	        return "ok";
	}
	/**
	 * 开始大量求情
	 * @throws InterruptedException 
	 */
	@RequestMapping("/manyRequest2")
	@ResponseBody
	public String manyRequest2() throws InterruptedException{
		Long timeStart=  System.currentTimeMillis();
		 int count = 1000;
	        List<Thread> workers = new ArrayList<Thread>();
	        for(int i = 0; i < count; i++) {
	            Thread worker = new Thread(new Runnable() {
	                public void run() {
	                	asdfService.plusValidAddPeriod();
	                }
	            });
	            worker.start();
	            workers.add(worker);
	        }
	        for(int i = 0; i < count; i++) {
	            workers.get(i).join();
	        }
	        Long timeEnd=  System.currentTimeMillis();
	        Long timeRun=timeEnd-timeStart;
	        System.out.println("请求全部完毕,执行主线程"+timeRun);
	        return "ok";
	}
	/**
	 * 开始大量求情
	 * @throws InterruptedException 
	 */
	@RequestMapping("/manyRequest3")
	@ResponseBody
	public String manyRequest3() throws InterruptedException{
		
		 int count = 1000;
	        List<Thread> workers = new ArrayList<Thread>();
	        for(int i = 0; i < count; i++) {
	            Thread worker = new Thread(new Runnable() {
	                public void run() {
	                	asdfService.investLoan();
	                }
	            });
	            worker.start();
	            workers.add(worker);
	        }
	        for(int i = 0; i < count; i++) {
	            workers.get(i).join();
	        }
	        System.out.println("请求全部完毕,执行主线程");
	        
	        return "ok";
	}
	@RequestMapping("/autoInsc")
	@ResponseBody
	public String autoInsc() throws InterruptedException{
		
		int count = 1000;
		List<Thread> workers = new ArrayList<Thread>();
		for(int i = 0; i < count; i++) {
			Thread worker = new Thread(new Runnable() {
				public void run() {
					asdfService.autoIncrement();
				}
			});
			worker.start();
			workers.add(worker);
		}
		for(int i = 0; i < count; i++) {
			workers.get(i).join();
		}
		System.out.println("请求全部完毕,执行主线程--------->"+AsdfService.i);
		
		return "ok";
	}
	
	@RequestMapping("/executorsingleTT")
	@ResponseBody
	public String executorTT(){
		    Long timeStart=  System.currentTimeMillis();
		    Integer resInt=  singleExecutor();
		    Long timeEnd=  System.currentTimeMillis();
	        Long timeRun=timeEnd-timeStart;
	        System.out.println("请求全部完毕,执行主线程"+timeRun);
	        
	        
		System.out.println("线程返回的返回值"+resInt);
		return"ok";
	}
	private Integer singleExecutor() {
		ExecutorService es=  Executors.newSingleThreadExecutor();
		
		for(int i=0;i<1000;i++){
			es.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					System.out.println("执行线程"+Thread.currentThread().getName());
					return asdfService.plusValidSetPeriod();
				}
			});
		}
		
		return 0;
	}
/*	private Integer singleExecutor2() {
		ExecutorService es=  Executors.newSingleThreadExecutor();
		List<Thread> workers = new ArrayList<Thread>();
		for(int i=0;i<1000;i++){
			es.execute();
		}
		
		return 0;
	}*/
	@RequestMapping("/blockLinkedQueue")
	@ResponseBody
	public  String blockLinkedQueue(){
		
		
		/*String id = "4";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Asdf a= asdfDao.findAsdfById(map);//拿到ID4剩余量
		System.out.println( "当前多少"+ a.getValid());
		    a.getValid();
		    int period=a.getValid()+1;
		    map.put("period", period);
		    map.put("id", id);
		   asdfDao.plusValidSetPeriod(map);
		   return period;*/
		
		 Asdf asdf=new Asdf();
		 asdf.setId(4);
		 asdf.setValid(1);
		  try {
			queue.put(asdf);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "ok";
	}
	
	
	
	
	
	public static void main(String[] args) {
		BigDecimal investMoney=new BigDecimal("12000");
		int loanMonthPeriod=1;
		if(investMoney.compareTo(new BigDecimal("100"))==-1||investMoney.compareTo(new BigDecimal("1000000"))==1){
			System.out.println("ok");
		}else{
			System.out.println("---->BigDecimal");
			BigDecimal actAwardRate = BigDecimal.ZERO;// 奖励利率
			BigDecimal customAwardVoucherDenomination = BigDecimal.ZERO;// 定制红包金额
			if (loanMonthPeriod >= 1 && loanMonthPeriod < 3) {
				actAwardRate = new BigDecimal("0.03");
			} else if (loanMonthPeriod >= 3 && loanMonthPeriod < 6) {
				actAwardRate = new BigDecimal("0.035");
			} else if (loanMonthPeriod >= 6 && loanMonthPeriod < 12) {
				actAwardRate = new BigDecimal("0.04");
			} else if (loanMonthPeriod >= 12) {
				actAwardRate = new BigDecimal("0.045");
			} else {
				
			}
			// 计算生成的定义红包金额
			customAwardVoucherDenomination = investMoney.multiply(actAwardRate)
					.multiply(new BigDecimal(loanMonthPeriod))
					.divide(new BigDecimal(12), 0, BigDecimal.ROUND_DOWN);
			System.out.println(customAwardVoucherDenomination);
		}
		/*User u=new User();
		u.setId("1");
		String dfasdf=u.getName().toString();
		System.out.println(dfasdf);*/
	}

	@RequestMapping("/randommm")
	@ResponseBody
	public String randommm( BigDecimal investMoney,Long userId ) throws InterruptedException{
		
		asdfService.getRandomTest(investMoney,userId);
		return ""+investMoney+"----"+userId;
	}
	
	
	
	
}

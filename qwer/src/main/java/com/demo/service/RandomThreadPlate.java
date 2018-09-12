package com.demo.service;

import java.beans.beancontext.BeanContext;
import java.math.BigDecimal;

import java.util.Date;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.common.SpringContextUtil;
import com.demo.dao.OrderDao;
import com.demo.entity.Order;
@Service
public class RandomThreadPlate implements Runnable{

	@Autowired
	private OrderDao orderDao;
	
	private Map<String,Object> paramsMap;

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}
	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	@Override
	public void run() {


		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 BigDecimal investMoney= new BigDecimal(  paramsMap.get("investMoney").toString());
		 Long userId=  (Long) paramsMap.get("userId");
		 Long randomChanges=  (long) (investMoney.doubleValue()/10);
		 Random r=new Random();
		  this.orderDao= SpringContextUtil.getBean("orderDao");
		  for(int i=0;i<randomChanges;i++){
			  int rr=   r.nextInt(10);
				 Order order2=new Order();//保存用户订单
					order2.setOrderTime(new Date());
					order2.setUserId(userId);
					order2.setValid(rr);
					order2.setType(10);
					orderDao.insertOrderRecord(order2);
		  }
		
		
		
	}
	

}

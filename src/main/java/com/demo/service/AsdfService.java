package com.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
		// throw new RuntimeException("�����");

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
		Asdf a= asdfDao.findAsdfById(map);//�õ�ID1ʣ����
		System.out.println( "ʣ�����"+ a.getValid());
		Random r = new Random();
		int nextInt = r.nextInt(10);
		map.put("period", nextInt);
		
		if(nextInt<=a.getValid()){
			int changeNumber=asdfDao.subtractValid(map);
			if(changeNumber>0){
				resultMap.put("status", "success");
				resultMap.put("data", nextInt);
				resultMap.put("msg", "�����ɹ�");
				return resultMap;
				
			}else{
				resultMap.put("status", "fail");
				resultMap.put("data", nextInt);
				resultMap.put("msg", "����ʧ��");
				return resultMap;
			}
		}else{
			resultMap.put("status", "fail");
			resultMap.put("msg", "�Ѿ�û����");
			return resultMap;
		}

	}

	public  Integer plusValidSetPeriod() {
		
//		synchronized (AsdfService.class) {
		String id = "4";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		Asdf a= asdfDao.findAsdfById(map);//�õ�ID4ʣ����
		System.out.println( "��ǰ����"+ a.getValid());
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
		Asdf a= asdfDao.findAsdfByIdForUpdate(map);//�õ�ID4ʣ����
		System.out.println( "��ǰ����"+ a.getValid());
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
			Asdf a= asdfDao.findAsdfById(map);//�õ�ID1ʣ����
			map.put("period", 1);
			map.put("id", id);
			asdfDao.plusValidAddPeriod(map);
			
		
		}

	public synchronized  void investLoan() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "5");
		Asdf a= asdfDao.findAsdfById(map);//�õ�ID1ʣ����
		System.out.println( "ʣ�����"+ a.getValid());
		Random r=new Random();
		 int nextInt=   r.nextInt(10)+1;//����֧����Ǯ
		if(nextInt<=a.getValid()){//�����Խ���Ͷ��
			
			Order order=new Order();//��ʼ֧��
			order.setOrderTime(new Date());
			order.setUserId(Thread.currentThread().getId());
			order.setValid(nextInt);
			order.setType(1);
			orderDao.insertOrderRecord(order);//�û�֧������˾�˻��ˡ�
			System.out.println("֧���ɹ�");
			map.put("period", nextInt);
			int changeNumber=asdfDao.subtractValid(map);
			if(changeNumber>0){
				System.out.println("Ͷ�ʳɹ�");
				Order order2=new Order();//�����û�����
				order2.setOrderTime(new Date());
				order2.setUserId(Thread.currentThread().getId());
				order.setValid(nextInt);
				order.setType(2);
				orderDao.insertOrderRecord(order);
			}
			
		}else{//ʣ�����Ѿ�������
			System.out.println("ʣ���Ͷ�ʽ���");
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
	public int insertDemo(Asdf asdf) {

		
		 return   asdfDao.insertDemo(asdf);
		
	}
	public void batchInserAsdfDemo() {
		Random r=new Random();
		Asdf asdf=new Asdf();
		for(int i=0;i<10;i++){
			asdf.setName("name"+i);
			asdf.setValue(Integer.toString(i));
			asdf.setValid(r.nextInt(10));
			asdfDao.insertDemo(asdf);
		}
	}
	public int insertBatchDemo() {

		List<Asdf> list=new ArrayList<Asdf>(10000);
		for(int i=1000;i<10000;i++){
			Asdf asdf=new Asdf();
			asdf.setId(i);
			asdf.setName("name"+i);
			asdf.setValue("value"+i);
			list.add(asdf);
		}
		
		
		
		
		
	   int batchCount=  asdfDao.insertBatchDemo(list);
		
		return batchCount;
	}



	

	
}

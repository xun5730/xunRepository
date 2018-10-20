package com.demo.service;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class InsertUserThreadDemo   implements Runnable{

	
	private List<String> list;
	
	
	
	
	/*private CountDownLatch countDownLatch;
 	
	public InsertUserThreadDemo(List<String> list,CountDownLatch countDownLatch  ){
		this.list=list;
		this.countDownLatch=countDownLatch;
	}*/
	
	
	public List<String> getList() {
		return list;
	}




	public void setList(List<String> list) {
		this.list = list;
	}




	@Override
	public void run() {

		for(String str:list){
			System.out.println(str);
		}
		
//		countDownLatch.countDown();
	}

	

}

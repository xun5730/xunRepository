package com.demo.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class Business {
	public void doBusiness(){
		System.out.println("�߳�ҵ��ʼ");
		ExecutorService es=   Executors.newCachedThreadPool();
		
		
		
	}
	

}

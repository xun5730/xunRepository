package com.demo.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class Business {
	public void doBusiness(){
		System.out.println("线程业务开始");
		ExecutorService es=   Executors.newCachedThreadPool();
		
		
		
	}
	

}

package com.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServcie {

	
	public String queryDemoStr(){
		String str="demoService";
		return str;
	}
	@Transactional
	public String insertDemoStr(){
		String str="insertDemoStr";
		return str;
	}
	
	
}

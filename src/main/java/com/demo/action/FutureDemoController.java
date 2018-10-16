package com.demo.action;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.Asdf;
import com.demo.service.AsdfService;

@Controller
@RequestMapping("futureDemo")
public class FutureDemoController {

	@Autowired
	private AsdfService asdfService;
	
	@RequestMapping("demo1")
	@ResponseBody
	public String demo1(){
		
	
		   asdfService.batchInserAsdfDemo();
		
		
		return "开始批量插入";
	}
	
	
	
}

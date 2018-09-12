package com.demo.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.service.AopDemoService;

@Controller
@RequestMapping("/aop")
public class AopController {

	@Autowired
	private AopDemoService aopDemoService;

	@RequestMapping("/queryDemo")
	@ResponseBody
	public String queryDemo(Model model, HttpServletRequest request) {
		
		
		
//		String r= aopDemoService.queryAopDemo();
		String r=  aopDemoService.queryAopDemo2();
		return r;

	}

}

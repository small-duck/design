package com.zy.spring.demo.action;


import com.zy.spring.demo.service.IDemoService;
import com.zy.spring.spring.annotation.Autower;
import com.zy.spring.spring.annotation.Controller;
import com.zy.spring.spring.annotation.RequestMapping;

@Controller
public class MyAction {

		@Autower
		IDemoService demoService;
	
		@RequestMapping("/index.html")
		public void query(){

		}
	
}

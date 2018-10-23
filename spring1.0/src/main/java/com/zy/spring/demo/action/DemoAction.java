package com.zy.spring.demo.action;


import com.zy.spring.demo.service.IDemoService;
import com.zy.spring.spring.annotation.Autower;
import com.zy.spring.spring.annotation.Controller;
import com.zy.spring.spring.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/demo")
public class DemoAction {
	
	@Autower
	private IDemoService demoService;
	
	@RequestMapping("/query.json")
	public void query(HttpServletRequest req, HttpServletResponse resp,
					   String name){
		String result = demoService.get(name);
		System.out.println(result);
//		try {
//			resp.getWriter().write(result);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	@RequestMapping("/edit.json")
	public void edit(HttpServletRequest req,HttpServletResponse resp,Integer id){

	}
	
}

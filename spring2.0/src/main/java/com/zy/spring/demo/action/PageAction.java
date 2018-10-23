package com.zy.spring.demo.action;


import com.zy.spring.demo.service.IQueryService;
import com.zy.spring.formework.annotaiton.GPAutowired;
import com.zy.spring.formework.annotaiton.GPController;
import com.zy.spring.formework.annotaiton.GPRequestMapping;
import com.zy.spring.formework.annotaiton.GPRequestParam;
import com.zy.spring.formework.webmvc.GPModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 公布接口url
 * @author Tom
 *
 */
@GPController
@GPRequestMapping("/")
public class PageAction {

	@GPAutowired
	IQueryService queryService;
	
	@GPRequestMapping("/first.html")
	public GPModelAndView query(@GPRequestParam("teacher") String teacher){
		String result = queryService.query(teacher);
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("teacher", teacher);
		model.put("data", result);
		model.put("token", "123456");
		return new GPModelAndView("first.html",model);
	}
	
}

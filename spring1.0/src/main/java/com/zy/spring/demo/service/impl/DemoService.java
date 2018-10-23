package com.zy.spring.demo.service.impl;


import com.zy.spring.demo.service.IDemoService;
import com.zy.spring.spring.annotation.Service;

@Service
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name;
	}

}

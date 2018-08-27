package com.xiaoma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoma.service.Articleservice;
@Controller
public class MainController {
	@Autowired
	private Articleservice articleservice;
	
	
	@RequestMapping("/index")
	public String index(Model m)
	{
		m.addAttribute("article",articleservice.getARTICLE_List());
		return "thymeleaf/index";
	}
	@RequestMapping("/about")
	public String about()
	{
		return "thymeleaf/about";
	}
	@RequestMapping("/gbook")
	public String gbook()
	{
		return "thymeleaf/gbook";
	}
	@RequestMapping("/info")
	public String info()
	{
		return "thymeleaf/info";
	}
	@RequestMapping("/list")
	public String list()
	{
		return "thymeleaf/list";
	}
	@RequestMapping("/share")
	public String share()
	{
		return "thymeleaf/share";
	}
	
	
	//登录验证功能
	//登录状态功能
	//登录注销功能
	
}

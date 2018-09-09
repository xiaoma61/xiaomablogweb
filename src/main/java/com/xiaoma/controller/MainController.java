package com.xiaoma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainController {
	
	
	
	@RequestMapping("/index")
	public String index(Model m)
	{
		//���������б�
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
	
	
	//��¼��֤����
	//��¼״̬����
	//��¼ע������
	
}

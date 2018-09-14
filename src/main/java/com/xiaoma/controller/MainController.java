package com.xiaoma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaoma.entity.ARTICLE;
import com.xiaoma.service.ArticleService;
@Controller
public class MainController {
	@Autowired()
	private  ArticleService articleService;
	
	@RequestMapping("/index")
	public String index(Model m,@RequestParam(name="pages",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size)
	{
		//导入文章列表
		String ISSHOW="1";
		Page<ARTICLE> article=articleService.findARTICLECriteria(page, size, ISSHOW);
		m.addAttribute("articles",article);
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

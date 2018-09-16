package com.xiaoma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	//用户登陆注册
	//用户修改个人呢信息
	//用户评论显示以及删除，查看评论文章
	//用户收藏的文章，点赞的文章
	//用户改变头像和背景图片
	//用户添加日志，删除日志
	//用户上传照片墙，管理照片墙
	//用户关注和点赞
	
	@RequestMapping("User/index")
	public String  UserIndex(Model m)
	{
		
		return "thymeleaf/User/index";
		
	}
	
	@RequestMapping("User/calendar")
	public String  UserCalendar(Model m)
	{
		
		return "thymeleaf/User/calendar";
		
	}
	
	@RequestMapping("User/ContentWidgets")
	public String  UserContentWidgets(Model m)
	{
		
		return "thymeleaf/User/content-widgets";
		
	}
	
	
	

}

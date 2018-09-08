package com.xiaoma.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoma.entity.ADMINISTRATOR;
import com.xiaoma.repository.ADMINISTRATORReposity;

@Controller
public class AdminController {
	@Autowired 
	private  ADMINISTRATORReposity administratorreposity;
	
	@RequestMapping("/Admin/index")
	public String AdminIndex()
	{
		return "thymeleaf/Admin/index";
		
	}
	@RequestMapping("/Admin/member-list")//文章列表
	public String AdminMemberList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	@RequestMapping("/Admin/member-del")//删除文章
	public String AdminMemberDel()
	{
		return "thymeleaf/Admin/member-del";
		
	}
	@RequestMapping("/Admin/member-edit")//文章上传
	public String AdminMemberEdit()
	{
		return "thymeleaf/Admin/member-edit";
		
	}
	@RequestMapping("/Admin/member-through")//浏览记录
	public String AdminMemberThrough()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	@RequestMapping("/Admin/comment-list")//评论列表
	public String AdminCommentList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	
	
	@RequestMapping("/Admin/IP-list")//流量统计
	public String AdminIPList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	@RequestMapping("/Admin/logslist")//日志列表
	public String AdminLogList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	
	@RequestMapping("/Admin/logEdit")//日志上传
	public String AdminLogEdit()
	{
		return "thymeleaf/Admin/member-edit";
		
	}
	
	@RequestMapping("/Admin/PageView")//访问量
	public String AdminPageView()
	{
		return "thymeleaf/Admin/echarts1";
		
	}
	@RequestMapping("/Admin/Commentsindex")//评论指数
	public String AdminCommentsindex()
	{
		return "thymeleaf/Admin/echarts2";
		
	}
	@RequestMapping("/Admin/articleheat")//文章热度
	public String Adminarticleheat()
	{
		return "thymeleaf/Admin/echarts4";
		
	}
	@RequestMapping("/Admin/member-level")//登录
	public String AdminMemberlevel()
	{
		return "thymeleaf/Admin/list";
		
	}
	
	
	@RequestMapping("/Admin/login")//登录
	public String AdminLogin()
	{
		return "thymeleaf/Admin/login";
		
	}
	@RequestMapping("/Admin/addlogin")//登录
	public String AdminAddLogin(HttpServletRequest request,HttpSession session)
	{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		ADMINISTRATOR administrator=administratorreposity.findBynameAndPassword(name, password);
		if(administrator!=null){
			//成功登陆回到后台
			session.setAttribute("name", name);//存储
			return "redirect:/Admin/index";
		}else
		{
			return "redirect:/Admin/login";
		}
		
		
		
	}
	
	
	
	

}

package com.xiaoma.controller;

import java.sql.Date;
import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaoma.Util.TimeUtil;
import com.xiaoma.entity.ADMINISTRATOR;
import com.xiaoma.entity.ARTICLE;
import com.xiaoma.repository.ADMINISTRATORReposity;
import com.xiaoma.repository.ARTICLERepository;
import com.xiaoma.service.ArticleService;

@Controller
public class AdminController {
	@Autowired 
	private  ADMINISTRATORReposity administratorreposity;
	@Autowired 
	private  ArticleService articleService;
	@Autowired 
	ARTICLERepository articleRepository;
	@RequestMapping("/Admin/index")
	public String AdminIndex()
	{
		return "thymeleaf/Admin/index";
		
	}

	@RequestMapping("/Admin/member-list")//文章列表
	public String AdminMemberList(Model m,@RequestParam(name="pages",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="title",defaultValue="text")String title
			,@RequestParam(name="StartDate", defaultValue="startdate")String sDate,@RequestParam(name="EndDate", defaultValue="enddate")String eDate) throws ParseException
	{
		//在这里导入文章列表
		//实现分页
	
		String flag=title;
		if(!(sDate.equals("startdate")||eDate.equals("enddate")))
		{
			Date sSqlDate=TimeUtil.StringToDate(sDate);
			Date eSqlDate=TimeUtil.StringToDate(eDate);
			Page<ARTICLE> article=articleService.findByCREATETIMEBetween(page, size, sSqlDate, eSqlDate);
			/*
			
			System.out.println("article ------1。。。。" +article.getSize());*/
			
			m.addAttribute("articles",article);
			return "thymeleaf/Admin/member-list";
		
		}
		else if(sDate.equals("startdate")&&!eDate.equals("enddate"))
		{
			Date SqlDate=TimeUtil.StringToDate(eDate);
			System.out.println("enddate ------1。。。。" +eDate);
			Page<ARTICLE> article=articleService.findByCREATETIMELike(page, size, SqlDate);
			m.addAttribute("articles",article);
			return "thymeleaf/Admin/member-list";
		}
		else if(eDate.equals("enddate")&&!sDate.equals("startdate"))
		{
			Date SqlDate=TimeUtil.StringToDate(sDate);
			System.out.println("startdate ------1。。。。" +sDate);
			Page<ARTICLE> article=articleService.findByCREATETIMELike(page, size, SqlDate);
			m.addAttribute("articles",article);
			return "thymeleaf/Admin/member-list";
		}
		//根据日期，文章标题查找（这种状态如何）
		if(!(flag.equals("text")))//equals有效其他无效
		{
			Page<ARTICLE> article=articleService.findALLByTitle(page, size, title);
			m.addAttribute("articles",article);
			/*System.out.println("title ------1。。。。" +title);
			System.out.println("flag ------1。。。。" +flag);
			System.out.println("article ------1。。。。。" +article.getNumber());*/
			return "thymeleaf/Admin/member-list";
			
		}
		else
		{
			//文章标题查找模糊查找
			Page<ARTICLE> article;/*articleService.findARTICLECriteria(page, size);**/
			article=articleService.findARTICLECriteria(page, size);
			m.addAttribute("articles",article);
			System.out.println("title ------2.。。。。" +title);
			return "thymeleaf/Admin/member-list";
		}
		
	
		
		
		//实现批量删除，在主页不显示
			
		
		
		
		//重新编写文章（更新操作）

		
	}
	/*@RequestMapping("/Admin/member-listfindtitle")//文章列表
	public String AdminMemberListFindTitle(Model m,@RequestParam(name="pages",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="title",defaultValue="")String title)
	{
		//在这里导入文章列表
		//实现分页
	
		String flag=title;
		if(!(flag.equals("")))
		{
			Page<ARTICLE> article=articleService.findALLByTitle(page, size, title);
			m.addAttribute("articles",article);
			System.out.println("title ------1。。。。" +title);
			System.out.println("flag ------1。。。。" +flag);
			System.out.println("article ------1。。。。。" +article.getNumber());
			return "thymeleaf/Admin/member-list";
			
		}
		else
		{
			Page<ARTICLE> article;articleService.findARTICLECriteria(page, size);*
			article=articleService.findARTICLECriteria(page, size);
			m.addAttribute("articles",article);
			System.out.println("title ------2.。。。。" +title);
			return "thymeleaf/Admin/member-list";
		}
		
		//删除文章（更新状态）
		
		//文章标题查找模糊查找
		
		
		
		//实现批量删除，在主页不显示
			
		
		//根据日期，文章标题查找（这种状态如何）
		
		//重新编写文章（更新操作）

		
	}
	*/
	
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

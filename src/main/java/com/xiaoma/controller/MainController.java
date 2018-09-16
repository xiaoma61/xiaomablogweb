package com.xiaoma.controller;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaoma.Util.TimeUtil;
import com.xiaoma.entity.ARTICLE;
import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.repository.ARTICLECOMMENTRepository;
import com.xiaoma.repository.ARTICLERepository;
import com.xiaoma.service.ArticleService;
@Controller
public class MainController {
	@Autowired()
	private  ArticleService articleService;
	@Autowired()
	private ARTICLERepository articleRepository;
	@Autowired()
	private ARTICLECOMMENTRepository articlecommentRepository;
	
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
	public String info(Model m,@RequestParam(name="ID",defaultValue="-1")int ID)
	{
		//跳转文章
		ARTICLE a=articleRepository.findByID(ID);
		m.addAttribute("articles",a);
		
		//上一篇文章id-1，下一篇文章id+1
		ARTICLE Nexta=articleRepository.findByID(ID+1);
		m.addAttribute("Nextarticles",Nexta);
		
		ARTICLE Lasta=articleRepository.findByID(ID-1);
		m.addAttribute("Lastarticles",Lasta);
		
		//如果没有返回列表
	    if(ID==-1)
		{
			System.out.println(ID);
			return "redirect:index";
		}
		
		//相关文章标题模糊搜索
		List<ARTICLE> Similara=articleRepository.findByTITLELike(a.getTITLE(),1);
		System.out.println(Similara.size());
		m.addAttribute("SimilarArticles",Similara);
	
		//评论区。。先做一个模板，在后台操作
		
		//登陆操作
		
		
		return "thymeleaf/info";
	}
	//实现标签列表跳转
	@RequestMapping("/LableList")
	public String LablePage(Model m, @RequestParam(name="pages",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size,@RequestParam(name="Lable",defaultValue="暂无")String Label)
	{
		String ISSHOW="1";		
		Page<ARTICLE> article;
		//没有筛选时的
		if(Label.equals("暂无"))
		{
			//全部的文章
		 article =articleService.findARTICLECriteria(page, size, ISSHOW);
			
		}else
		{
			article=articleService.findByLabel(page, size, Label, ISSHOW);
		}
		m.addAttribute("articles",article);
		
		
		return "thymeleaf/list";
		
	}
	
	
	@RequestMapping("/Comment")
	public String list()
	{
		return "thymeleaf/Comment";
	}
	@RequestMapping("/share")
	public String share()
	{
		return "thymeleaf/share";
	}
	@RequestMapping("/User/Comment")
	public String UserComment(@RequestParam(value="comment")String comment,@RequestParam(value="ARTICLEid")int ARTICLEid,HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		
		
		if(session.getAttribute("Name")==""||session.getAttribute("Name")==null){
			return "redirect:/User/Login";
			
		}
		else
		{
			//将评论存下来
			int ID=(Integer) session.getAttribute("ID");
			int USERID=ID;
			int PRAISENUMS=0;
			int ARTICLEID=ARTICLEid;
			Date time=TimeUtil.GetDate();
			ARTICLECOMMENT articlecomment=new ARTICLECOMMENT();
			articlecomment.setArticleid(ARTICLEID);
			articlecomment.setContent(comment);
			articlecomment.setTime(time);
			articlecomment.setPraisenums(PRAISENUMS);
			articlecomment.setUserid(USERID);
			articlecommentRepository.save(articlecomment);
			return "thymeleaf/share";
				
			
		}
		
	}
	
	//登录验证功能
	//登录状态功能
	//登录注销功能
	
}

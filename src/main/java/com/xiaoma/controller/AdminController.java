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

	@RequestMapping("/Admin/member-list")//�����б�
	public String AdminMemberList(Model m,@RequestParam(name="pages",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="title",defaultValue="text")String title
			,@RequestParam(name="StartDate", defaultValue="startdate")String sDate,@RequestParam(name="EndDate", defaultValue="enddate")String eDate) throws ParseException
	{
		//�����ﵼ�������б�
		//ʵ�ַ�ҳ
	
		String flag=title;
		if(!(sDate.equals("startdate")||eDate.equals("enddate")))
		{
			Date sSqlDate=TimeUtil.StringToDate(sDate);
			Date eSqlDate=TimeUtil.StringToDate(eDate);
			Page<ARTICLE> article=articleService.findByCREATETIMEBetween(page, size, sSqlDate, eSqlDate);
			/*
			
			System.out.println("article ------1��������" +article.getSize());*/
			
			m.addAttribute("articles",article);
			return "thymeleaf/Admin/member-list";
		
		}
		else if(sDate.equals("startdate")&&!eDate.equals("enddate"))
		{
			Date SqlDate=TimeUtil.StringToDate(eDate);
			System.out.println("enddate ------1��������" +eDate);
			Page<ARTICLE> article=articleService.findByCREATETIMELike(page, size, SqlDate);
			m.addAttribute("articles",article);
			return "thymeleaf/Admin/member-list";
		}
		else if(eDate.equals("enddate")&&!sDate.equals("startdate"))
		{
			Date SqlDate=TimeUtil.StringToDate(sDate);
			System.out.println("startdate ------1��������" +sDate);
			Page<ARTICLE> article=articleService.findByCREATETIMELike(page, size, SqlDate);
			m.addAttribute("articles",article);
			return "thymeleaf/Admin/member-list";
		}
		//�������ڣ����±�����ң�����״̬��Σ�
		if(!(flag.equals("text")))//equals��Ч������Ч
		{
			Page<ARTICLE> article=articleService.findALLByTitle(page, size, title);
			m.addAttribute("articles",article);
			/*System.out.println("title ------1��������" +title);
			System.out.println("flag ------1��������" +flag);
			System.out.println("article ------1����������" +article.getNumber());*/
			return "thymeleaf/Admin/member-list";
			
		}
		else
		{
			//���±������ģ������
			Page<ARTICLE> article;/*articleService.findARTICLECriteria(page, size);**/
			article=articleService.findARTICLECriteria(page, size);
			m.addAttribute("articles",article);
			System.out.println("title ------2.��������" +title);
			return "thymeleaf/Admin/member-list";
		}
		
	
		
		
		//ʵ������ɾ��������ҳ����ʾ
			
		
		
		
		//���±�д���£����²�����

		
	}
	/*@RequestMapping("/Admin/member-listfindtitle")//�����б�
	public String AdminMemberListFindTitle(Model m,@RequestParam(name="pages",defaultValue="0")int page,@RequestParam(name="size",defaultValue="5")int size,@RequestParam(name="title",defaultValue="")String title)
	{
		//�����ﵼ�������б�
		//ʵ�ַ�ҳ
	
		String flag=title;
		if(!(flag.equals("")))
		{
			Page<ARTICLE> article=articleService.findALLByTitle(page, size, title);
			m.addAttribute("articles",article);
			System.out.println("title ------1��������" +title);
			System.out.println("flag ------1��������" +flag);
			System.out.println("article ------1����������" +article.getNumber());
			return "thymeleaf/Admin/member-list";
			
		}
		else
		{
			Page<ARTICLE> article;articleService.findARTICLECriteria(page, size);*
			article=articleService.findARTICLECriteria(page, size);
			m.addAttribute("articles",article);
			System.out.println("title ------2.��������" +title);
			return "thymeleaf/Admin/member-list";
		}
		
		//ɾ�����£�����״̬��
		
		//���±������ģ������
		
		
		
		//ʵ������ɾ��������ҳ����ʾ
			
		
		//�������ڣ����±�����ң�����״̬��Σ�
		
		//���±�д���£����²�����

		
	}
	*/
	
	@RequestMapping("/Admin/member-del")//ɾ������
	public String AdminMemberDel()
	{
		return "thymeleaf/Admin/member-del";
		
	}
	@RequestMapping("/Admin/member-edit")//�����ϴ�
	public String AdminMemberEdit()
	{
		return "thymeleaf/Admin/member-edit";
		
	}
	@RequestMapping("/Admin/member-through")//�����¼
	public String AdminMemberThrough()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	@RequestMapping("/Admin/comment-list")//�����б�
	public String AdminCommentList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	
	
	@RequestMapping("/Admin/IP-list")//����ͳ��
	public String AdminIPList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	@RequestMapping("/Admin/logslist")//��־�б�
	public String AdminLogList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
	
	@RequestMapping("/Admin/logEdit")//��־�ϴ�
	public String AdminLogEdit()
	{
		return "thymeleaf/Admin/member-edit";
		
	}
	
	@RequestMapping("/Admin/PageView")//������
	public String AdminPageView()
	{
		return "thymeleaf/Admin/echarts1";
		
	}
	@RequestMapping("/Admin/Commentsindex")//����ָ��
	public String AdminCommentsindex()
	{
		return "thymeleaf/Admin/echarts2";
		
	}
	@RequestMapping("/Admin/articleheat")//�����ȶ�
	public String Adminarticleheat()
	{
		return "thymeleaf/Admin/echarts4";
		
	}
	@RequestMapping("/Admin/member-level")//��¼
	public String AdminMemberlevel()
	{
		return "thymeleaf/Admin/list";
		
	}
	
	
	@RequestMapping("/Admin/login")//��¼
	public String AdminLogin()
	{
		return "thymeleaf/Admin/login";
		
	}
	@RequestMapping("/Admin/addlogin")//��¼
	public String AdminAddLogin(HttpServletRequest request,HttpSession session)
	{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		ADMINISTRATOR administrator=administratorreposity.findBynameAndPassword(name, password);
		if(administrator!=null){
			//�ɹ���½�ص���̨
			session.setAttribute("name", name);//�洢
			return "redirect:/Admin/index";
		}else
		{
			return "redirect:/Admin/login";
		}
		
		
		
	}
	
	
	
	

}

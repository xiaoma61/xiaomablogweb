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
	@RequestMapping("/Admin/member-list")//�����б�
	public String AdminMemberList()
	{
		return "thymeleaf/Admin/member-list";
		
	}
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

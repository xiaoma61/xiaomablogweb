package com.xiaoma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	//�û���½ע��
	//�û��޸ĸ�������Ϣ
	//�û�������ʾ�Լ�ɾ�����鿴��������
	//�û��ղص����£����޵�����
	//�û��ı�ͷ��ͱ���ͼƬ
	//�û������־��ɾ����־
	//�û��ϴ���Ƭǽ��������Ƭǽ
	//�û���ע�͵���
	
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

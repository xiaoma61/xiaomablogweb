package com.xiaoma.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoma.entity.USERMSG;
import com.xiaoma.repository.USERMSGRepository;

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
	@Autowired
	USERMSGRepository userMsgRepository;
	
	@RequestMapping("User/Login")
	public String  UserLogin(Model m)
	{
		
		return "thymeleaf/User/Login";
		
	}
	//ȡ����½
	@RequestMapping("User/LoseLogin")
	public String  UserLoseLogin(Model m)
	{
		
		return "thymeleaf/User/index";
		
	}
	@RequestMapping("User/Register")
	public String  UserRegisterPage()
	{
		return "thymeleaf/User/register";
		
	}
	
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
	
	
	//ע����֤�Ƿ��������
	@RequestMapping(value="User/Register/CheckName",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String>  UserCheckName(Model m,@RequestParam("Name")String Name)
	{
		
		Map<String, String> map=new HashMap<String, String>();
		USERMSG u=userMsgRepository.findUSRByName(Name);
		
		if(u!=null)
		{
			/*System.out.print(" hello"+u.getNAME());*/
			map.put("data","wrong" );
			
		}else
		{
			map.put("data","success" );
		}
		return map ;
		
	}
	
	//ע��ɹ�
	@RequestMapping("User/Register/CheckNamePassWord")
	public String  UserRegister(Model m,@RequestParam("Name")String Name,@RequestParam("Password")String Password)
	{
		USERMSG u=userMsgRepository.findUSRByName(Name);
		if(u!=null)
		{
			System.out.println(Password);
			return "redirect:/User/Register";
		}else
		{
			//�ɹ�ע��
			USERMSG U=new USERMSG();
			U.setNAME(Name);
			U.setPASSWORD(Password);
			userMsgRepository.save(U);
			
			System.out.println(Name);
			return "redirect:/User/Login";
		}
	
		
	}
	//��½��֤
	@RequestMapping("User/LoginCheck")
	public String  UserLoginCheck(Model m,@RequestParam("Name")String Name,@RequestParam("Password")String Password,HttpServletRequest request)
	{
		USERMSG u=userMsgRepository.findUSRByNameAndPASSWORD(Name, Password);
		if(u!=null)
		{
			//����
			HttpSession session=request.getSession();
			session.setAttribute("Name", u.getNAME());
			session.setAttribute("ID",u.getID());
			System.out.println("Name :" +u.getNAME());
			System.out.println("ID :"+u.getID());
			return "redirect:/index";
			
		}else
		{
			//�ɹ���½
			System.out.println("success");
			return "redirect:/User/Login";
		}
	
		
	}
	
	
	
	

}

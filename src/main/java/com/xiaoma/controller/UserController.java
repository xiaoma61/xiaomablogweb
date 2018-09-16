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
	
	//用户登陆注册
	//用户修改个人呢信息
	//用户评论显示以及删除，查看评论文章
	//用户收藏的文章，点赞的文章
	//用户改变头像和背景图片
	//用户添加日志，删除日志
	//用户上传照片墙，管理照片墙
	//用户关注和点赞
	@Autowired
	USERMSGRepository userMsgRepository;
	
	@RequestMapping("User/Login")
	public String  UserLogin(Model m)
	{
		
		return "thymeleaf/User/Login";
		
	}
	//取消登陆
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
	
	
	//注册验证是否存在名字
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
	
	//注册成功
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
			//成功注册
			USERMSG U=new USERMSG();
			U.setNAME(Name);
			U.setPASSWORD(Password);
			userMsgRepository.save(U);
			
			System.out.println(Name);
			return "redirect:/User/Login";
		}
	
		
	}
	//登陆验证
	@RequestMapping("User/LoginCheck")
	public String  UserLoginCheck(Model m,@RequestParam("Name")String Name,@RequestParam("Password")String Password,HttpServletRequest request)
	{
		USERMSG u=userMsgRepository.findUSRByNameAndPASSWORD(Name, Password);
		if(u!=null)
		{
			//存入
			HttpSession session=request.getSession();
			session.setAttribute("Name", u.getNAME());
			session.setAttribute("ID",u.getID());
			System.out.println("Name :" +u.getNAME());
			System.out.println("ID :"+u.getID());
			return "redirect:/index";
			
		}else
		{
			//成功登陆
			System.out.println("success");
			return "redirect:/User/Login";
		}
	
		
	}
	
	
	
	

}

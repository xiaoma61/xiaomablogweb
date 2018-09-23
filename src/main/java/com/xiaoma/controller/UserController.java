package com.xiaoma.controller;

import java.util.HashMap;
import java.util.List;
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

import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.entity.FOLLOW;
import com.xiaoma.entity.USERMSG;
import com.xiaoma.repository.ARTICLECOMMENTRepository;
import com.xiaoma.repository.FOLLOWRepository;
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
	@Autowired
	FOLLOWRepository followRepository;
	@Autowired
	ARTICLECOMMENTRepository articleRepository;
	
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
	public String  UserIndex(Model m,HttpServletRequest request)
	{
		//实现截图
		//实现聊天信息
		int ID=(Integer) request.getAttribute("ID");
		List<ARTICLECOMMENT> articlecomment=articleRepository.findByBELONGID(ID);
		List<ARTICLECOMMENT> articlecomment1=articleRepository.findByBELONGIDandPARENTID(0, ID);
		
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
			session.setAttribute("IMAGE",u.getIMAGE());
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
	
	//实现裁剪头像
	@RequestMapping("User/HeadImage")
	@ResponseBody()
	public Map<String, String>  UserHeadImage(Model m,@RequestParam("HeadImage")String HeadImage,HttpServletRequest request)
	{
		Map<String, String> map=new HashMap<String, String>();
		
		
		
		return map;
	
		
	}
	
	//聊天记录显示，跳转个人主页，跳转文章主页
	//关注显示聊天动态，更新动态取关，喜欢
	@RequestMapping("User/Follow")
	@ResponseBody()
	public Map<String, String>  UserFollow(Model m,@RequestParam("TOID")int TOID,@RequestParam("ISLIKE")int ISLIKE,@RequestParam("ISFOLLOW")int ISFOLLOW,HttpServletRequest request)
	{
		//islike为1的话插入，为2的话更新,isfollow=1的时候
		Map<String, String> map=new HashMap<String, String>();
		int FROMID=(Integer) request.getAttribute("ID");
	    FOLLOW f=followRepository.findByTOID(TOID, FROMID);
	     
		if(f==null)
		{
			FOLLOW f1=new FOLLOW();
			f1.setFOLLOW(ISFOLLOW);
			f1.setFROMID(FROMID);
			f1.setLIKETO(ISLIKE);
			f1.setTOID(TOID);
			followRepository.save(f1);
			
		}else{
			
			followRepository.UpdateByTOID(ISLIKE, ISFOLLOW, FROMID, TOID);
		}
		
		return map;
	
		
	}
	//个人相册
	//个人信息编辑
	//个人行程编辑，将要来到的事情编辑
	
	
	
	

}

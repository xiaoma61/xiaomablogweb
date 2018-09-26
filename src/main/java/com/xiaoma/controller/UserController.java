package com.xiaoma.controller;

import java.sql.Date;
import java.util.ArrayList;
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

import com.xiaoma.Util.PageUtil;
import com.xiaoma.Util.TimeUtil;
import com.xiaoma.Util.articlecommentUtil;
import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.entity.ARTICLECOMMENTUSERANDCOMMENT;
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
	ARTICLECOMMENTRepository articlecommentRepository;
	
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
	public String  UserIndex(Model m,HttpServletRequest request,@RequestParam(value="ID",defaultValue="-1")int ID)
	{
		//实现截图
		//实现聊天信息更新
		
		HttpSession session=request.getSession();
		int IDm=1;
		if(session.getAttribute("ID")!=null)
		{
			IDm=(Integer) session.getAttribute("ID");
		}else
		{
			return "thymeleaf/index";
		}
		if(ID==-1){
			ID=IDm;
		}
		
		
		
		//制作轮询
		List<ARTICLECOMMENT> articlecomment=new ArrayList<ARTICLECOMMENT>();
		articlecomment=articlecommentRepository.findByBELONGID(ID,0);
		List<ARTICLECOMMENT> articlecomment1=new ArrayList<ARTICLECOMMENT>();
		articlecommentRepository.findByBELONGIDandPARENTID(0, ID,0);
		articlecomment.addAll(articlecomment1);
		
	
		//评论讯息
	    if(articlecomment.size()>0)
	    {
	    	System.out.println("DDDD   "+articlecomment.size());
	    	List<ARTICLECOMMENTUSERANDCOMMENT>articlecommentuserandcommentList=new ArrayList<ARTICLECOMMENTUSERANDCOMMENT>();
			for(int i=0;i<articlecomment.size();i++)
			{
				ARTICLECOMMENTUSERANDCOMMENT  articlecommentuserandcomment=new ARTICLECOMMENTUSERANDCOMMENT();
				int USERID =articlecomment.get(i).getUSERID();
				USERMSG usermsg=userMsgRepository.findOne( USERID);	
				articlecommentuserandcomment.setArticlecomment(articlecomment.get(i));
				articlecommentuserandcomment.setUsermsg(usermsg);
				
				articlecommentuserandcommentList.add(articlecommentuserandcomment);
				
				
				
				
			}
	    	PageUtil<ARTICLECOMMENTUSERANDCOMMENT> pageutil=new PageUtil<ARTICLECOMMENTUSERANDCOMMENT>(articlecommentuserandcommentList,1,5);
			m.addAttribute("pageutil", pageutil);
	    }
		
		//关注他人，他人关注自己
		List<FOLLOW>TOIDFOLLOWf=followRepository.findByTOIDAndFOLLOW(ID, 2);
		List<FOLLOW>TOIDISLIKEf=followRepository.findByTOIDAndISLIKE(ID, 2);
		List<FOLLOW>FROMIDf=followRepository.findByFROMID(ID,2);
		
		
		
		//关注的人的动态
		//发表的评论,发表的文章
		List<ARTICLECOMMENT>articlecommetf=new ArrayList<ARTICLECOMMENT>();
	
		for(int i=0;i<TOIDFOLLOWf.size();i++){
			
			Date TIME=TimeUtil.GetDate();
			List<ARTICLECOMMENT> articlecomment2=articlecommentRepository.findByUSERID(TOIDFOLLOWf.get(i).getID(),TIME);
			articlecommetf.addAll(articlecomment2);
			
		}

		List<ARTICLECOMMENTUSERANDCOMMENT>articlecommentuserandcommentList1=articlecommentUtil.GetcommnetUtil(articlecommetf);
		PageUtil<ARTICLECOMMENTUSERANDCOMMENT> pageutil1=new PageUtil<ARTICLECOMMENTUSERANDCOMMENT>(articlecommentuserandcommentList1,1,5);
		m.addAttribute("pageutil1", pageutil1);
		//我的关注
		List<USERMSG>usermsglist1=new ArrayList<USERMSG>();
		for(int i=0;i<FROMIDf.size();i++){
			USERMSG usermsg=userMsgRepository.findOne(FROMIDf.get(i).getID());
			usermsglist1.add(usermsg);
			
		}
		PageUtil<USERMSG> pageutil2=new PageUtil<USERMSG>(usermsglist1,1,5);
		m.addAttribute("pageutil2", pageutil2);
		
		
		
		//访问者
		
		if(articlecomment!=null)
		{
			session.setAttribute("articlecommentnums", articlecomment.size());
		}
		session.setAttribute("articlecommentnums", 0);
		m.addAttribute("TOIDISLIKEfnums", TOIDISLIKEf.size());
	
		//关注和喜欢是否
		FOLLOW f=followRepository.findByFROMIDAndTOIDandLIKETO(IDm, ID, 2);
		FOLLOW f1=followRepository.findByFROMIDAndTOIDandFOLLOW(IDm, ID, 2);
		
		if(f!=null)
		{
			m.addAttribute("islike", 2);
		}
		if(f1!=null)
		{
			m.addAttribute("isfollow", 2);
		}
		//个人信息
		USERMSG usermsgID=userMsgRepository.findOne(ID);
		
		
		m.addAttribute("usermsgID", usermsgID);
		
		
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
	public Map<String, String>  UserFollow(Model m,@RequestParam("TOID")int TOID,@RequestParam(value="ISLIKE",defaultValue="1")int ISLIKE,@RequestParam(value="ISFOLLOW" ,defaultValue="1")int ISFOLLOW,HttpServletRequest request)
	{
		//islike为1的话插入，为2的话更新,isfollow=1的时候
		Map<String, String> map=new HashMap<String, String>();

		HttpSession session=request.getSession();
		
		int FROMID=(Integer) session.getAttribute("ID");
		
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
	//消息轮询

	@RequestMapping("User/indexMsg")
	public Map<String ,Object>  UserMsg(HttpServletRequest request)
	{
		Map<String,Object> map=new HashMap<String, Object>();
		//实现截图
		//实现聊天信息更新

		HttpSession session=request.getSession();
		
		int ID=(Integer) session.getAttribute("ID");
		List<ARTICLECOMMENT> articlecomment=articlecommentRepository.findByBELONGID(ID,0);
		List<ARTICLECOMMENT> articlecomment1=articlecommentRepository.findByBELONGIDandPARENTID(0, ID,0);
		articlecomment.addAll(articlecomment1);
		//制作轮询

		int size=(Integer) session.getAttribute("articlecommentnums");
		if(size!=articlecomment.size())
		{
			session.setAttribute("articlecommentnums", articlecomment.size());
			
			
			List<ARTICLECOMMENTUSERANDCOMMENT>articlecommentuserandcommentList=articlecommentUtil.GetcommnetUtil(articlecomment);
			map.put("articlecommentuserandcommentList", articlecommentuserandcommentList);
			
			return map;
			//发送回去信息
		}else
		{
			
			map.put("data","lose");
			return map;
		}

		
		
		
		
		
		
	}
	
	@RequestMapping("User/indexcropper")
	public String  Usercropper(HttpServletRequest request)
	{
		return "thymeleaf/User/cropper";
	}
	//个人相册
	//个人信息编辑
	//个人行程编辑，将要来到的事情编辑
	
	
	
	

}

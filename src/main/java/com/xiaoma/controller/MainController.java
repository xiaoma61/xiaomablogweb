package com.xiaoma.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoma.Util.PageUtil;
import com.xiaoma.Util.TimeUtil;
import com.xiaoma.entity.ARTICLE;
import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.entity.ARTICLECOMMENTUSERANDCOMMENT;
import com.xiaoma.entity.ARTICLECOMMENTUSERANDCOMMENTLIST;
import com.xiaoma.entity.USERMSG;
import com.xiaoma.repository.ARTICLECOMMENTRepository;
import com.xiaoma.repository.ARTICLERepository;
import com.xiaoma.repository.USERMSGRepository;
import com.xiaoma.service.ArticleService;
@Controller
public class MainController {
	@Autowired
	private  ArticleService articleService;
	@Autowired
	private ARTICLERepository articleRepository;
	@Autowired
	private ARTICLECOMMENTRepository articlecommentRepository;
	
	@Autowired
	private USERMSGRepository userRepository;
	/*
	@Autowired
	private ARTICLECOMMENTService articlecommentService;*/
	
	@RequestMapping("/index")
	public String index(Model m,@RequestParam(name="pages",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size)
	{
		//���������б�
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
	public String info(Model m,@RequestParam(name="ID",defaultValue="-1")int ID,@RequestParam(name="Page",defaultValue="1")int Page,@RequestParam(name="Size",defaultValue="5")int Size)
	{
		//��ת����
		ARTICLE a=articleRepository.findByID(ID);
		m.addAttribute("articles",a);
		
		//��һƪ����id-1����һƪ����id+1
		ARTICLE Nexta=articleRepository.findByID(ID+1);
		m.addAttribute("Nextarticles",Nexta);
		
		ARTICLE Lasta=articleRepository.findByID(ID-1);
		m.addAttribute("Lastarticles",Lasta);
		
		//���û�з����б�
	    if(ID==-1)
		{
			System.out.println(ID);
			return "redirect:index";
		}
		
		//������±���ģ������
		List<ARTICLE> Similara=articleRepository.findByTITLELike(a.getTITLE(),1);
		System.out.println(Similara.size());
		m.addAttribute("SimilarArticles",Similara);
	
		//��������������һ��ģ�壬�ں�̨����
		//��������ʾ
		List<ARTICLECOMMENT>articlecomment=articlecommentRepository.findByARTICLEID(ID,0);
		List<ARTICLECOMMENTUSERANDCOMMENT>articlecommentuserandcommentList=new ArrayList<ARTICLECOMMENTUSERANDCOMMENT>();
		
		
		
		//��parentIDΪ0�Ĳ��룬�ٲ���parentIDΪID�Ĳ���
		
		
		for(int i=0;i<articlecomment.size();i++)
		{
			ARTICLECOMMENTUSERANDCOMMENT  articlecommentuserandcomment=new ARTICLECOMMENTUSERANDCOMMENT();
			int USERID =articlecomment.get(i).getUSERID();
			int articlecommentID=articlecomment.get(i).getID();
			
			
			
			
			
			List<ARTICLECOMMENT>articlecomments1=articlecommentRepository.findByARTICLEID(ID, articlecommentID);

			List<ARTICLECOMMENTUSERANDCOMMENTLIST> articleuserandcommentlist=new ArrayList<ARTICLECOMMENTUSERANDCOMMENTLIST>();
			for(int t=0;t<articlecomments1.size();t++)
			{
			
				ARTICLECOMMENTUSERANDCOMMENTLIST articleuserandcomment=new ARTICLECOMMENTUSERANDCOMMENTLIST();
				
				int USERID1 =articlecomments1.get(t).getUSERID();				
				USERMSG usermsg=userRepository.findOne( USERID1);	
				
				articleuserandcomment.setUsermsg(usermsg);
				articleuserandcomment.setArticlecomment(articlecomments1.get(t));
				articleuserandcommentlist.add(articleuserandcomment);
							
			}
		
				
				PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST>  articleuserandcommentlistpageutil=new PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST>(articleuserandcommentlist,1,Size);
				USERMSG usermsg=userRepository.findOne( USERID);
				articlecommentuserandcomment.setArticlecomment(articlecomment.get(i));
				articlecommentuserandcomment.setUsermsg(usermsg);
	
				articlecommentuserandcomment.setArticleuserandcommentlist(articleuserandcommentlistpageutil);
				
				
				articlecommentuserandcommentList.add(articlecommentuserandcomment);
		
			
		}

		PageUtil<ARTICLECOMMENTUSERANDCOMMENT> pageutil=new PageUtil<ARTICLECOMMENTUSERANDCOMMENT>(articlecommentuserandcommentList,Page,Size);
		
		
		
		m.addAttribute("articlecommentuserandcommentList",pageutil);
		
		return "thymeleaf/info";
	}
	//ʵ�ֱ�ǩ�б���ת
	@RequestMapping("/LableList")
	public String LablePage(Model m, @RequestParam(name="pages",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="10")int size,@RequestParam(name="Lable",defaultValue="����")String Label)
	{
		String ISSHOW="1";		
		Page<ARTICLE> article;
		//û��ɸѡʱ��
		if(Label.equals("����"))
		{
			//ȫ��������
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
	@RequestMapping(value="/User/Comment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> UserComment(@RequestParam(value="comments")String comment,@RequestParam(value="ARTICLEid")int ARTICLEid,
			
			@RequestParam(value="PARENTID",defaultValue="0")int PARENTID,@RequestParam(value="BELONGID",defaultValue="0")int BELONGID,
			/*@PathVariable("comments") String comment,@PathVariable("ARTICLEid") int ARTICLEid,@RequestParam(value="PARENTID",defaultValue="0")int PARENTID,@RequestParam(value="BELONGID",defaultValue="0")int BELONGID,*/
			
			
			HttpServletRequest request)
	{
		HttpSession session=request.getSession();
		Map<String,Object> data=new HashMap<String, Object>();
		
		if(session.getAttribute("Name")==""||session.getAttribute("Name")==null){
		
			data.put("data", "lose");
			return data;
			
		}
		else
		{
			
			
		
			
			int ID=(Integer) session.getAttribute("ID");
			String IMAGE=(String) session.getAttribute("IMAGE");
			String NAME=(String) session.getAttribute("Name");
			int USERID=ID;
			int PRAISENUMS=0;
			int ARTICLEID=ARTICLEid;
			Date time=TimeUtil.GetDate();
			ARTICLECOMMENT articlecomment=new ARTICLECOMMENT();
			articlecomment.setARTICLEID(ARTICLEID);
			articlecomment.setCONTENT(comment);
			articlecomment.setTIME(time);
			articlecomment.setPRAISENUMS(PRAISENUMS);
			articlecomment.setUSERID(USERID);
			articlecomment.setPARENTID(PARENTID);
			articlecomment.setBELONGID(BELONGID);
			articlecommentRepository.save(articlecomment);
			//�õ�User��Ϣ ʱ��Ի�����
			USERMSG usermsg=new USERMSG();
			usermsg.setID(ID);
			usermsg.setIMAGE(IMAGE);
			usermsg.setNAME(NAME);
			ARTICLECOMMENTUSERANDCOMMENT  articlecommentuserandcomment=new ARTICLECOMMENTUSERANDCOMMENT();
			articlecommentuserandcomment.setArticlecomment(articlecomment);
			articlecommentuserandcomment.setUsermsg(usermsg);
			data.put("data", articlecommentuserandcomment);
			
			
			return data;
			
			
			
			
			
		
				
			
		}
		
	}
	
	//������������ҳ ��ʾ����
	
	@RequestMapping(value="/User/SecondComment",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> UserSecondCommentt(@RequestParam(value="ARTICLEid")int ARTICLEid,
			
			@RequestParam(value="PARENTID",defaultValue="0")int PARENTID,@RequestParam(name="Pages",defaultValue="1")int Page,@RequestParam(name="Size",defaultValue="5")int Size)
	{
		
		Map<String,Object> data=new HashMap<String, Object>();
		List<ARTICLECOMMENT>articlecomments1=articlecommentRepository.findByARTICLEID(ARTICLEid, PARENTID);
		List<ARTICLECOMMENTUSERANDCOMMENTLIST> articleuserandcommentlist=new ArrayList<ARTICLECOMMENTUSERANDCOMMENTLIST>();
		for(int t=0;t<articlecomments1.size();t++)
		{
		
			ARTICLECOMMENTUSERANDCOMMENTLIST articleuserandcomment=new ARTICLECOMMENTUSERANDCOMMENTLIST();
			
			int USERID1 =articlecomments1.get(t).getUSERID();				
			USERMSG usermsg=userRepository.findOne( USERID1);	
			
			articleuserandcomment.setUsermsg(usermsg);
			articleuserandcomment.setArticlecomment(articlecomments1.get(t));
			articleuserandcommentlist.add(articleuserandcomment);
						
		}
		
		PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST>  articleuserandcommentlistpageutil=new PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST>(articleuserandcommentlist,1,Size);
		data.put("data", articleuserandcommentlistpageutil);
		return data;
		
		
	}
	//ʵ�ֵ���Ч��
	
	@RequestMapping(value="/User/Parise",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> UserParise(@RequestParam(value="PRAISENUMS") int PRAISENUMS,@RequestParam(value="ID") int ID,HttpServletRequest request)
	{
		
		HttpSession session=request.getSession();
		Map<String,Object> data=new HashMap<String, Object>();
		
		if(session.getAttribute("Name")==""||session.getAttribute("Name")==null){
		
			data.put("data", "lose");
			return data;
			
		}else
		{
			articlecommentRepository.UpdatePRAISENUMSByID(PRAISENUMS,ID);
			data.put("data", "success");
			return data;
		}
	
		
		
	}
	
	//��¼״̬����
	//��¼ע������
	
}

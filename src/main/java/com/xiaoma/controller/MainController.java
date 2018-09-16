package com.xiaoma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xiaoma.entity.ARTICLE;
import com.xiaoma.repository.ARTICLERepository;
import com.xiaoma.service.ArticleService;
@Controller
public class MainController {
	@Autowired()
	private  ArticleService articleService;
	@Autowired()
	private ARTICLERepository articleRepository;
	
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
	public String info(Model m,@RequestParam(name="ID",defaultValue="-1")int ID)
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
		
		//��½����
		
		
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
	
	
	//��¼��֤����
	//��¼״̬����
	//��¼ע������
	
}

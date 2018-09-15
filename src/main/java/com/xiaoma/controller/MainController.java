package com.xiaoma.controller;

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
		
		ARTICLE Nexta=articleRepository.findByID(ID+1);
		m.addAttribute("Nextarticles",Nexta);
		
		ARTICLE Lasta=articleRepository.findByID(ID-1);
		m.addAttribute("Lastarticles",Lasta);
		
		
		if(ID==-1)
		{
			
			return "redirect:index";
		}
		//ʵ�ֱ�ǩ��ת
		
		//��һƪ����id-1����һƪ����id+1
		//���û�з����б�
		
		//������±���ģ������
		
		
		//��������������һ��ģ�壬�ں�̨����
		
		//��½����
		
		
		//Ҫ��Ҫ����������
		
		
		
		
		return "thymeleaf/info";
	}
	@RequestMapping("/list")
	public String list()
	{
		return "thymeleaf/list";
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

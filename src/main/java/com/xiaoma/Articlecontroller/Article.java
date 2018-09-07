package com.xiaoma.Articlecontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoma.Util.TimeUtil;
import com.xiaoma.entity.ARTICLE;
import com.xiaoma.service.impl.ArticleserviceImpl;

@Controller
public class Article {
	
	/*//接受文件并且传入数据库
		@RequestMapping(value="/goArticle")
		public String goArticle(@RequestParam(name="article")String articletext,@RequestParam(name="title")String title,@RequestParam(name="label")String label,@RequestParam(name="introduction")String introduction,HttpSession session)
		{
			if(articletext==""||(articletext==null)||title==""||title==null||label==""||label==null||introduction==null||introduction=="")
			{
				return "thymeleaf/Admin/member-edit";
			}
			else
			{
				String createtime=TimeUtil.GetDate();
				int praisenums=0;
				int visitorsnums=0;
				String writer=(String) session.getAttribute("name");
				ARTICLE article=new ARTICLE();
				article.setCreatetime(createtime);
				article.setIntroduction(introduction);
				article.setLabel(label);
				article.setPraisenums(praisenums);
				article.setVisitorsnums(visitorsnums);
				article.setWriter(writer);
				ArticleserviceImpl articleImpl=new ArticleserviceImpl();
				articleImpl.add(article);
				System.out.print("LastName: ");
				System.out.print("filepath: ");
				return "success";
			}
		
		}
		@RequestMapping(value="/SaveArticle")
		public @ResponseBody String SaveArticle(@RequestParam(name="article")String articletext,@RequestParam(name="title")String title,@RequestParam(name="label")String label,@RequestParam(name="introduction")String introduction,HttpSession session)
		{
			//将文章插入数据库
			String createtime=TimeUtil.GetDate();
			int praisenums=0;
			int visitorsnums=0;
			String writer=(String) session.getAttribute("name");
			ARTICLE article=new ARTICLE();
			article.setCreatetime(createtime);
			article.setIntroduction(introduction);
			article.setLabel(label);
			article.setPraisenums(praisenums);
			article.setVisitorsnums(visitorsnums);
			article.setWriter(writer);
			ArticleserviceImpl articleImpl=new ArticleserviceImpl();
			articleImpl.add(article);
			System.out.print("LastName: ");
			System.out.print("filepath: ");
			return "success";
			
			
			//获取时间
			
		}*/
		
		

}


package com.xiaoma.Articlecontroller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoma.Util.FileUtil;
import com.xiaoma.Util.TimeUtil;
import com.xiaoma.entity.ARTICLE;
import com.xiaoma.service.impl.ArticleserviceImpl;

@Controller
public class Article {
	
//接受文件并且传入数据库
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
			
		}
		
	//以上为页面跳转
	//图片上传
	@RequestMapping(value="/goUploadImg")
	public String goUploadImg()
	{
		System.out.print("LastName: ");
		return "uploadImg";
	}
	@RequestMapping(value="/uploadImg")
	public @ResponseBody String uploadImg(@RequestParam("thumbnail")MultipartFile file ,HttpServletRequest request) throws IOException
	{
		/*String contentType=file.getContentType();//获取文件类型
*/		String fileName=file.getOriginalFilename();//获取文件名称
		System.out.print("LastName: ");
		String filePath="E://Skins/text";
		String LastName=UUID.randomUUID().toString()+fileName;
		byte[] filebyte=file.getBytes();
		FileUtil.uploadFile(filebyte, filePath,LastName);
	
		return "http://localhost:8090/image/text"+LastName;
		
	}


}


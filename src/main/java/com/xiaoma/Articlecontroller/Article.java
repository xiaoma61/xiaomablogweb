package com.xiaoma.Articlecontroller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoma.Util.FileUtil;
import com.xiaoma.Util.TimeUtil;
import com.xiaoma.entity.ARTICLE;
import com.xiaoma.repository.ARTICLERepository;

@Controller
public class Article {
	
//接受文件并且传入数据库
		
	@Autowired()
	private  ARTICLERepository  articleRepository;
	
	@RequestMapping(value="/goArticle")
	public String goArticle(@RequestParam(name="article")String articletext,@RequestParam(name="title")String title,@RequestParam(name="label")String label,@RequestParam(name="introduction")String introduction,HttpSession session)
	{
		String writer=(String) session.getAttribute("name");
		System.out.print(" writer: " +  writer);
		
		if( writer==null||writer=="")
		{
			writer="xiaoma";
			/*return "redirect:/Admin/login";*/
		}
		if(articletext==""||(articletext==null)||title==""||title==null||label==""||label==null||introduction==null||introduction=="")
		{
			return "redirect:/Admin/member-edit";
		}
		else
		{
			System.out.println("articletext: " + articletext);
			System.out.println("title: " + title);				
			System.out.println("introduction: " + introduction);
			System.out.println(" label: " +  label);
			
			String createtime=TimeUtil.GetDate();
			int praisenums=0;
			int visitorsnums=0;
			
			System.out.println(" label: " +  label);
			System.out.println(" writer: " +  writer);
			
			
			ARTICLE article=new ARTICLE();
			article.setCREATETIME(createtime);
			article.setINTRODUCTION(introduction);
			article.setLABEL(label);
			article.setPRAISENUMS(praisenums);
			article.setVISITORSNUMS(visitorsnums);
			article.setWRITER(writer);
			article.setTITLE(title);
			
			articleRepository.save(article);
			/*ArticleserviceImpl articleImpl=new ArticleserviceImpl();
			articleImpl.add(article);*/
			
			return "success";
		}
	
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


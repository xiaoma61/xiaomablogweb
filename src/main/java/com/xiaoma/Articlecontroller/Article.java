package com.xiaoma.Articlecontroller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		String writer=(String) session.getAttribute("name");//不生效
		System.out.print(" writer: " +  writer);
		
		if( writer==null||writer=="")
		{
			//出现的问题，writer在登陆的时候没有存储下来
			writer="xiaoma";
			/*return "redirect:/Admin/login";*/
		}
		
		{
			
			
			Date createtime=TimeUtil.GetDate();
			int praisenums=0;
			int visitorsnums=0;
					
			
			ARTICLE article=new ARTICLE();
			article.setCREATETIME(createtime);
			article.setINTRODUCTION(introduction);
			article.setLABEL(label);
			article.setPRAISENUMS(praisenums);
			article.setVISITORSNUMS(visitorsnums);
			article.setWRITER(writer);
			article.setTITLE(title);
			article.setISSHOW(1);
			article.setCONTENT(articletext);
			
			articleRepository.save(article);
			return "redirect:/Admin/member-edit";
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
*/	
	String fileName=file.getOriginalFilename();//获取文件名称
/*	System.out.print("LastName: ");*/
	String filePath="E://Skins/text";
	String LastName=UUID.randomUUID().toString()+fileName;
	byte[] filebyte=file.getBytes();
	FileUtil.uploadFile(filebyte, filePath,LastName);
	return "http://localhost:8090/image/text"+LastName;
	
}
//删除页面数据不显示
@RequestMapping(value="/articles/dodelete")
public void Dodelete(@RequestParam("id")int ID,@RequestParam(name="isshow",defaultValue="1")int isshow)
{
	
	articleRepository.updateISSHOWByID(isshow,ID);

}

@RequestMapping(value="/articles/dodeleteALL")
public void DodeleteALL()
{
	
	articleRepository.updateISSHOW(2);

}
@RequestMapping(value="/articles/dodeleteReal")
public void DodeleteReal(@RequestParam(name="ID")int ID)
{
	
	articleRepository.delete(ID);

}
//实现模糊查询和百度词汇
@RequestMapping(value="/articles/dofindtitle" , method = RequestMethod.POST)
@ResponseBody
public List<ARTICLE> DofindTitle(@RequestParam("Title")String Title,@RequestParam(name="isshow")int ISSHOW)
{
	List<ARTICLE>titles=articleRepository.findByTITLELike(Title,ISSHOW);
	if(Title==""||Title==null)
	{
		//提取前五个
		List<ARTICLE>titlesFive=new ArrayList<ARTICLE>();
		for(int i=0;i<5;i++)
		{
			titlesFive.add(titles.get(i));
		}
		return titlesFive;
	}
	else
	{
	
		return titles;
	}
	
	
}

@RequestMapping(value="/articles/doreEdit")
public String DoReEdit(@RequestParam(name="article")String articletext,@RequestParam(name="title")String title,@RequestParam(name="label")String label,@RequestParam(name="introduction")String introduction,@RequestParam(name="ID")int ID)
{

	articleRepository.updateByID(title, introduction, label,articletext , ID);
	//更新完成调整
	return "redirect:/Admin/AdminReEdit?ID="+ID;
}




}


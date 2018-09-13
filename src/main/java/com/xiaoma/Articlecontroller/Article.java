package com.xiaoma.Articlecontroller;

import java.io.IOException;
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
	
//�����ļ����Ҵ������ݿ�
		
	@Autowired()
	private  ARTICLERepository  articleRepository;
	
	@RequestMapping(value="/goArticle")
	public String goArticle(@RequestParam(name="article")String articletext,@RequestParam(name="title")String title,@RequestParam(name="label")String label,@RequestParam(name="introduction")String introduction,HttpSession session)
	{
		String writer=(String) session.getAttribute("name");//����Ч
		System.out.print(" writer: " +  writer);
		
		if( writer==null||writer=="")
		{
			//���ֵ����⣬writer�ڵ�½��ʱ��û�д洢����
			writer="xiaoma";
			/*return "redirect:/Admin/login";*/
		}
		
		{
			
			
			String createtime=TimeUtil.GetDate();
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
	
//����Ϊҳ����ת
//ͼƬ�ϴ�
@RequestMapping(value="/goUploadImg")
public String goUploadImg()
{
	System.out.print("LastName: ");
	return "uploadImg";
}
@RequestMapping(value="/uploadImg")
public @ResponseBody String uploadImg(@RequestParam("thumbnail")MultipartFile file ,HttpServletRequest request) throws IOException
{
	/*String contentType=file.getContentType();//��ȡ�ļ�����
*/		String fileName=file.getOriginalFilename();//��ȡ�ļ�����
	System.out.print("LastName: ");
	String filePath="E://Skins/text";
	String LastName=UUID.randomUUID().toString()+fileName;
	byte[] filebyte=file.getBytes();
	FileUtil.uploadFile(filebyte, filePath,LastName);

	return "http://localhost:8090/image/text"+LastName;
	
}
//ɾ��ҳ�����ݲ���ʾ
@RequestMapping(value="/articles/dodelete")
public void Dodelete(@RequestParam("id")int ID)
{
	
	articleRepository.updateISSHOWByID(2,ID);

}
//ʵ��ģ����ѯ�Ͱٶȴʻ�
@RequestMapping(value="/articles/dofindtitle" , method = RequestMethod.POST)
@ResponseBody
public List<ARTICLE> DofindTitle(@RequestParam("Title")String Title)
{
	
	List<ARTICLE>titles=articleRepository.findByTITLELike(Title);
	/*List<String>titlesList=new ArrayList<String>();
	for(int i=0;i<titles.size();i++)
	{
		titlesList.add(titles.get(i).getTITLE())
	}*/

	return titles;
	
}

}


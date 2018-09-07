package com.xiaoma.Articlecontroller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoma.Util.FileUtil;

@Controller
public class Article {
	//����Ϊҳ����ת
		//ͼƬ�ϴ�
		@RequestMapping(value="/goUploadImg")
		public String goUploadImg()
		{
			return "uploadImg";
		}
		@RequestMapping(value="/uploadImg")
		public @ResponseBody String uploadImg(@RequestParam("thumbnail")MultipartFile file ,HttpServletRequest request) throws IOException
		{
			/*String contentType=file.getContentType();//��ȡ�ļ�����
	*/		String fileName=file.getOriginalFilename();//��ȡ�ļ�����
			
			String filePath="E://Skins/text";
			String LastName=UUID.randomUUID().toString()+fileName;
			byte[] filebyte=file.getBytes();
			FileUtil.uploadFile(filebyte, filePath,LastName);
			System.out.print("LastName: "+LastName);
			System.out.print("filepath: "+filePath);
			return "http://localhost:8090/image/text"+LastName;
			
		}
	//�����ļ����Ҵ������ݿ�
		@RequestMapping(value="/goArticle")
		public String goArticle()
		{
			return "SaveArticle";
		}
		public @ResponseBody void SaveArticle()
		{
			
			
		}
		

}


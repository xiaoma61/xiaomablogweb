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
	//以上为页面跳转
		//图片上传
		@RequestMapping(value="/goUploadImg")
		public String goUploadImg()
		{
			return "uploadImg";
		}
		@RequestMapping(value="/uploadImg")
		public @ResponseBody String uploadImg(@RequestParam("thumbnail")MultipartFile file ,HttpServletRequest request) throws IOException
		{
			/*String contentType=file.getContentType();//获取文件类型
	*/		String fileName=file.getOriginalFilename();//获取文件名称
			
			String filePath="E://Skins/text";
			String LastName=UUID.randomUUID().toString()+fileName;
			byte[] filebyte=file.getBytes();
			FileUtil.uploadFile(filebyte, filePath,LastName);
			System.out.print("LastName: "+LastName);
			System.out.print("filepath: "+filePath);
			return "http://localhost:8090/image/text"+LastName;
			
		}
	//接受文件并且传入数据库
		@RequestMapping(value="/goArticle")
		public String goArticle()
		{
			return "SaveArticle";
		}
		public @ResponseBody void SaveArticle()
		{
			
			
		}
		

}


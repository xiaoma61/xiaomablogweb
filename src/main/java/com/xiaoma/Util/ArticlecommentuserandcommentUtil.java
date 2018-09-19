package com.xiaoma.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.entity.ARTICLECOMMENTUSERANDCOMMENT;
import com.xiaoma.entity.USERMSG;
import com.xiaoma.repository.ARTICLECOMMENTRepository;
import com.xiaoma.repository.USERMSGRepository;

public class ArticlecommentuserandcommentUtil {

	
	@Autowired
	private static USERMSGRepository userRepository;
	@Autowired
	private static ARTICLECOMMENTRepository articlecommentRepository;

	public static List<ARTICLECOMMENTUSERANDCOMMENT> GetList(List<ARTICLECOMMENT> articlecomment,int Size,int Page,int ID)
	{
		List<ARTICLECOMMENTUSERANDCOMMENT>articlecommentuserandcommentList=new ArrayList<ARTICLECOMMENTUSERANDCOMMENT>();
		for(int i=0;i<articlecomment.size();i++)
		{
			ARTICLECOMMENTUSERANDCOMMENT  articlecommentuserandcomment=new ARTICLECOMMENTUSERANDCOMMENT();
			int USERID =articlecomment.get(i).getUSERID();
			int articlecommentID=articlecomment.get(i).getID();
			
			/*PageUtil<ARTICLECOMMENTUSERANDCOMMENT>articlecomments=new PageUtil<ARTICLECOMMENTUSERANDCOMMENT>(articlecommentuserandcommentList,0,Size);*/
			List<ARTICLECOMMENT>articlecomments= articlecommentRepository.findByARTICLEID( articlecommentID, ID);
			
			for(int t=0;t<articlecomments.size();t++)
			{
				ARTICLECOMMENTUSERANDCOMMENT  articlecommentuserandcomments=new ARTICLECOMMENTUSERANDCOMMENT();
				int USERIDs =articlecomments.get(t).getUSERID();
				
				USERMSG usermsg=userRepository.findOne(USERIDs);
				
				articlecommentuserandcomments.setUsermsg(usermsg);
				
			}
			USERMSG usermsg=userRepository.findOne(USERID);
			articlecommentuserandcomment.setArticlecomment(articlecomment.get(i));
			articlecommentuserandcomment.setUsermsg(usermsg);
		
			articlecommentuserandcommentList.add(articlecommentuserandcomment);
		
			
		/*	System.out.println("list1ss :    "+articlecomments.getTotalPages());*/
			
		}
		return articlecommentuserandcommentList;
		
	}

}

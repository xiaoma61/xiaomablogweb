package com.xiaoma.Util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaoma.entity.ARTICLECOMMENT;
import com.xiaoma.entity.ARTICLECOMMENTUSERANDCOMMENT;
import com.xiaoma.entity.USERMSG;
import com.xiaoma.repository.USERMSGRepository;

public class articlecommentUtil {
	@Autowired
	static USERMSGRepository userMsgRepository;
	public static List<ARTICLECOMMENTUSERANDCOMMENT>GetcommnetUtil(List<ARTICLECOMMENT> articlecomment)
	{
		List<ARTICLECOMMENTUSERANDCOMMENT>articlecommentuserandcommentList=new ArrayList<ARTICLECOMMENTUSERANDCOMMENT>();
		for(int i=0;i<articlecomment.size();i++)
		{
			ARTICLECOMMENTUSERANDCOMMENT  articlecommentuserandcomment=new ARTICLECOMMENTUSERANDCOMMENT();
			int USERID =articlecomment.get(i).getUSERID();
			USERMSG usermsg=userMsgRepository.findOne( USERID);	
			articlecommentuserandcomment.setArticlecomment(articlecomment.get(i));
			articlecommentuserandcomment.setUsermsg(usermsg);
			
			articlecommentuserandcommentList.add(articlecommentuserandcomment);
			
			
			
		
			
		}


		return articlecommentuserandcommentList;
		
	}


}

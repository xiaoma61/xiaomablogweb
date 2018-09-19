package com.xiaoma.entity;

import com.xiaoma.Util.PageUtil;

public class ARTICLECOMMENTUSERANDCOMMENT {
	
	public ARTICLECOMMENT articlecomment;
	public USERMSG usermsg;

	public  PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST> articleuserandcommentlist;
	
	

	public ARTICLECOMMENT getArticlecomment() {
		return articlecomment;
	}
	public void setArticlecomment(ARTICLECOMMENT articlecomment) {
		this.articlecomment = articlecomment;
	}
	
	public USERMSG getUsermsg() {
		return usermsg;
	}
	public void setUsermsg(USERMSG usermsg) {
		this.usermsg = usermsg;
	}
	public PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST> getArticleuserandcommentlist() {
		return articleuserandcommentlist;
	}
	public void setArticleuserandcommentlist(PageUtil<ARTICLECOMMENTUSERANDCOMMENTLIST> articleuserandcommentlist) {
		this.articleuserandcommentlist = articleuserandcommentlist;
	}
	
	
	
	
	

}

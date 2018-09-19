package com.xiaoma.entity;

import org.springframework.data.domain.Page;

public class ARTICLECOMMENTUSERANDCOMMENT {
	
	public ARTICLECOMMENT articlecomment;
	public USERMSG usermsg;
	public Page<ARTICLECOMMENT> articlecommentList;
	public ARTICLECOMMENT getArticlecomment() {
		return articlecomment;
	}
	public void setArticlecomment(ARTICLECOMMENT articlecomment) {
		this.articlecomment = articlecomment;
	}
	public Page<ARTICLECOMMENT> getArticlecommentList() {
		return articlecommentList;
	}
	public void setArticlecommentList(Page<ARTICLECOMMENT> articlecommentList) {
		this.articlecommentList = articlecommentList;
	}
	public USERMSG getUsermsg() {
		return usermsg;
	}
	public void setUsermsg(USERMSG usermsg) {
		this.usermsg = usermsg;
	}
	
	
	

}

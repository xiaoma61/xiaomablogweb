package com.xiaoma.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ARTICLECOMMENT")
public class ARTICLECOMMENT {
	int articleid;
	int id;
	Date time;
	int userid;
	int parentid;
	String content;
	int  belongid;
	int praisenums;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ARTICLECOMMENTId")
	@SequenceGenerator(name="ARTICLECOMMENTId",initialValue=1,allocationSize=1,sequenceName="ARTICLECOMMENT_SEQUENCE")//ÐòÁÐÉú³ÉÆ÷
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getArticleid() {
		return articleid;
	}
	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBelongid() {
		return belongid;
	}
	public void setBelongid(int belongid) {
		this.belongid = belongid;
	}
	public int getPraisenums() {
		return praisenums;
	}
	public void setPraisenums(int praisenums) {
		this.praisenums = praisenums;
	}

}

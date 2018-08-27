package com.xiaoma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGEBOARD")
public class MESSAGEBOARD {
	int id;
	String time;
	int userid;
	int parentid;
	String content;
	int  belongid;
	int praisenums;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="MESSAGEBOARDId")
	@SequenceGenerator(name="MESSAGEBOARDId",initialValue=1,allocationSize=1,sequenceName="MESSAGEBOARD_SEQUENCE")//ÐòÁÐÉú³ÉÆ÷
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
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

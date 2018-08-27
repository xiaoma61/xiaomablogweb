package com.xiaoma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ARTICLE")
public class ARTICLE {
	int id;
	String title;
	int visitorsnums;
	int praisenums;
	String introduction;
	String label;
	String filearea;
	String createtime;
	String writer;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ARTICLEId")
	@SequenceGenerator(name="ARTICLEId",initialValue=1,allocationSize=1,sequenceName="ARTICLE_SEQUENCE")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getVisitorsnums() {
		return visitorsnums;
	}
	public void setVisitorsnums(int visitorsnums) {
		this.visitorsnums = visitorsnums;
	}
	public int getPraisenums() {
		return praisenums;
	}
	public void setPraisenums(int praisenums) {
		this.praisenums = praisenums;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getFilearea() {
		return filearea;
	}
	public void setFilearea(String filearea) {
		this.filearea = filearea;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	

}

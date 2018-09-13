package com.xiaoma.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="ARTICLE")
public class ARTICLE {
	int ID;
	String TITLE;
	int VISITORSNUMS;
	int PRAISENUMS;
	String INTRODUCTION;
	String LABEL;
	Date CREATETIME;
	String WRITER;
	String CONTENT;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ARTICLEId")
	@SequenceGenerator(name="ARTICLEId",initialValue=1,allocationSize=1,sequenceName="ARTICLE_SEQUENCE")
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getVISITORSNUMS() {
		return VISITORSNUMS;
	}
	public void setVISITORSNUMS(int vISITORSNUMS) {
		VISITORSNUMS = vISITORSNUMS;
	}
	public int getPRAISENUMS() {
		return PRAISENUMS;
	}
	public void setPRAISENUMS(int pRAISENUMS) {
		PRAISENUMS = pRAISENUMS;
	}
	public String getINTRODUCTION() {
		return INTRODUCTION;
	}
	public void setINTRODUCTION(String iNTRODUCTION) {
		INTRODUCTION = iNTRODUCTION;
	}
	public String getLABEL() {
		return LABEL;
	}
	public void setLABEL(String lABEL) {
		LABEL = lABEL;
	}
	


	public Date getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(Date cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}
	
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	int ISSHOW;//当为1的时候是可见状态，为2的时候不可见
	public int getISSHOW() {
		return ISSHOW;
	}
	public void setISSHOW(int iSSHOW) {
		ISSHOW = iSSHOW;
	}
	

}

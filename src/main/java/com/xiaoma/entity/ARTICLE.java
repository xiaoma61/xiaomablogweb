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
	int ID;
	String TITLE;
	int VISITORSNUMS;
	int PRAISENUMS;
	String INTRODUCTION;
	String LABEL;
	String CREATETIME;
	String WRITER;
	
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
	public String getCREATETIME() {
		return CREATETIME;
	}
	public void setCREATETIME(String cREATETIME) {
		CREATETIME = cREATETIME;
	}
	public String getWRITER() {
		return WRITER;
	}
	public void setWRITER(String wRITER) {
		WRITER = wRITER;
	}
	
	
	

}

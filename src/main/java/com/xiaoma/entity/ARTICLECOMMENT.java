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
	int ARTICLEID;
	int ID;
	Date TIME;
	int USERID;
	int PARENTID;
	String CONTENT;
	int  BELONGID;
	int PRAISENUMS;
	int ISREAD;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ARTICLECOMMENTId")
	@SequenceGenerator(name="ARTICLECOMMENTId",initialValue=1,allocationSize=1,sequenceName="ARTICLECOMMENT_SEQUENCE")//ÐòÁÐÉú³ÉÆ÷
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getARTICLEID() {
		return ARTICLEID;
	}
	public void setARTICLEID(int aRTICLEID) {
		ARTICLEID = aRTICLEID;
	}
	
	public Date getTIME() {
		return TIME;
	}
	public void setTIME(Date tIME) {
		TIME = tIME;
	}
	public int getUSERID() {
		return USERID;
	}
	public void setUSERID(int uSERID) {
		USERID = uSERID;
	}
	public int getPARENTID() {
		return PARENTID;
	}
	public void setPARENTID(int pARENTID) {
		PARENTID = pARENTID;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public int getBELONGID() {
		return BELONGID;
	}
	public void setBELONGID(int bELONGID) {
		BELONGID = bELONGID;
	}
	public int getPRAISENUMS() {
		return PRAISENUMS;
	}
	public void setPRAISENUMS(int pRAISENUMS) {
		PRAISENUMS = pRAISENUMS;
	}
	public int getISREAD() {
		return ISREAD;
	}
	public void setISREAD(int iSREAD) {
		ISREAD = iSREAD;
	}

	
}

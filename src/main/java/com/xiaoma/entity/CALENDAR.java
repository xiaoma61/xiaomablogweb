package com.xiaoma.entity;

import java.sql.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class CALENDAR {
	int ID;
	Date STARTTIME;
	Date ENDTIME;
	String EVENT;
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CALENDARId")
	@SequenceGenerator(name="CALENDARId",initialValue=1,allocationSize=1,sequenceName="CALENDAR_SEQUENCE")	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public Date getSTARTTIME() {
		return STARTTIME;
	}
	public void setSTARTTIME(Date sTARTTIME) {
		STARTTIME = sTARTTIME;
	}
	public Date getENDTIME() {
		return ENDTIME;
	}
	public void setENDTIME(Date eNDTIME) {
		ENDTIME = eNDTIME;
	}
	public String getEVENT() {
		return EVENT;
	}
	public void setEVENT(String eVENT) {
		EVENT = eVENT;
	}
	
	
	

}

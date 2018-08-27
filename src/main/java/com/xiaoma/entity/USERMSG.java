package com.xiaoma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USERMSG")
public class USERMSG {
	private String NAME;
	private int ID;
	private String IMAGE;
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="USERMSGId")
	@SequenceGenerator(name="USERMSGId",initialValue=1,allocationSize=1,sequenceName="USERMSG_SEQUENCE")
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getIMAGE() {
		return IMAGE;
	}
	public void setIMAGE(String iMAGE) {
		IMAGE = iMAGE;
	}
}

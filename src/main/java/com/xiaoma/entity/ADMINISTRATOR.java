package com.xiaoma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADMINISTRATOR")

public class ADMINISTRATOR {
	private String NAME;
	private int ID;
	private String IMAGE;
	private String PASSWORD;
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="ADMINISTRATORId")
	@SequenceGenerator(name="ADMINISTRATORId",initialValue=1,allocationSize=1,sequenceName="ADMINISTRATOR_SEQUENCE")
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
	
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	

}

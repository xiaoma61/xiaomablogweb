package com.xiaoma.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FOLLOW")
public class FOLLOW {
	int ID;
	int FROMID;
	int TOID;
	int LIKETO;
	int FOLLOW;
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="FOLLOWid")
	@SequenceGenerator(name="FOLLOWid",initialValue=1,allocationSize=1,sequenceName="FOLLOWID")
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getFROMID() {
		return FROMID;
	}
	public void setFROMID(int fROMID) {
		FROMID = fROMID;
	}
	public int getTOID() {
		return TOID;
	}
	public void setTOID(int tOID) {
		TOID = tOID;
	}
	public int getLIKETO() {
		return LIKETO;
	}
	public void setLIKETO(int lIKETO) {
		LIKETO = lIKETO;
	}
	public int getFOLLOW() {
		return FOLLOW;
	}
	public void setFOLLOW(int fOLLOW) {
		FOLLOW = fOLLOW;
	}
	
	

}

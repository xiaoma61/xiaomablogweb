package com.xiaoma.repository;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.xiaoma.entity.CALENDAR;
@Transactional
public interface CALENDARRepository  extends JpaRepository< CALENDAR,Integer>{
	@Query("select a from CALENDAR a where a.FROMID=?1")
	List<CALENDAR>findALLByFROMID(int FROMID);
	
	@Query("update CALENDAR c set c.STARTTIME=?1 , c.ENDTIME=?2  where  c.ID=?3")
	@Modifying
	int updateByStartAndEnd(Date s,Date e,int id);
	
	@Query("update CALENDAR c set  c.ENDTIME=?1  where  c.ID=?2")
	@Modifying
	int updateByEnd(Date e,int id);

}

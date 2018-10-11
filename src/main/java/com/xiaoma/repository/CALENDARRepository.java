package com.xiaoma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xiaoma.entity.CALENDAR;

public interface CALENDARRepository  extends JpaRepository< CALENDAR,Integer>{
	@Query("select a from CALENDAR a where FROMID=?1")
	List<CALENDAR>findALLByFROMID(int FROMID);

}

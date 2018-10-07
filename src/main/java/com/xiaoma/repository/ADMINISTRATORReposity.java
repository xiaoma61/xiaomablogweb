package com.xiaoma.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xiaoma.entity.ADMINISTRATOR;
@Repository
@Transactional
public interface ADMINISTRATORReposity extends JpaRepository<ADMINISTRATOR,Integer>{
	@Query("select a from ADMINISTRATOR a where a.NAME=?1 And a.PASSWORD=?2")
	public ADMINISTRATOR findBynameAndPassword(String name,String password);
	
	
}



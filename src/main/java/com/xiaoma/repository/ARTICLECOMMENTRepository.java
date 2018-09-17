package com.xiaoma.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xiaoma.entity.ARTICLECOMMENT;

@Repository
@Transactional
public interface ARTICLECOMMENTRepository extends JpaRepository<ARTICLECOMMENT,Integer>{
	
	
	@Query("select a from ARTICLECOMMENT a where a.ARTICLEID=?1")
	public List<ARTICLECOMMENT>fingByARTICLEID(int  ARTICLEID);

}

package com.xiaoma.repository;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.xiaoma.entity.ARTICLECOMMENT;

@Repository
@Transactional
public interface ARTICLECOMMENTRepository extends JpaRepository<ARTICLECOMMENT,Integer>{
	
	public Page<ARTICLECOMMENT> findAll(Specification<ARTICLECOMMENT> specification, Pageable pageable);
	
	
	@Query("select a from ARTICLECOMMENT a where a.ARTICLEID=?1 and a.PARENTID=?2")//查找一级
	public List<ARTICLECOMMENT>findByARTICLEID(int  ARTICLEID,int PARENTID);
	
	
	@Query("select a from ARTICLECOMMENT a where a.PARENTID=?1")//查找二级
	public List<ARTICLECOMMENT>findByPARENTID(int  PARENTID);//查找
	
	
	@Query("update  ARTICLECOMMENT a  set a.PRAISENUMS=?1 where a.ID=?2")//查找二级
	@Modifying
	public int UpdatePRAISENUMSByID(int PRAISENUMS, int  ID);//查找
	
	
	@Query("select a from ARTICLECOMMENT a where a.BELONGID=?1")//查找二级
	public List<ARTICLECOMMENT>findByBELONGID(int  BELONGID);//查找
	
	@Query("select a from ARTICLECOMMENT a where a.BELONGID=?1 and a.PARENTID=?2")//查找二级
	public List<ARTICLECOMMENT>findByBELONGIDandPARENTID(int  BELONGID,int PARENTID);//查找

}

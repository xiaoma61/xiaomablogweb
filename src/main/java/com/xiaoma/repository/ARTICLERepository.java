package com.xiaoma.repository;
import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.xiaoma.entity.ARTICLE;
@Transactional
public interface ARTICLERepository extends JpaRepository<ARTICLE,Integer>{

	Page<ARTICLE> findAll(Specification<ARTICLE> specification, Pageable pageable);
	
	@Query(value ="update ARTICLE a set a.ISSHOW=?1 where a.ID=?2")
	@Modifying
	public int updateISSHOWByID(int ISSHOW,int ID );
	
	@Query(value ="update ARTICLE a set a.ISSHOW=?1")
	@Modifying
	public int updateISSHOW(int ISSHOW );
	
	@Query(value ="select a from ARTICLE a where a.TITLE like %?1% and a.ISSHOW=?2 ")
	public List<ARTICLE>findByTITLELike(String TITLE,int ISSHOW);
	
	@Query(value ="select a from ARTICLE a where a.CREATETIME like %?1% ")
	public List<ARTICLE>findByCREATETIMELike(Date CREATETIME);
	
	
	@Query(value ="select a from ARTICLE a where a.ID =?1 ")
	public ARTICLE findByID(int ID);
	
	@Query(value ="update ARTICLE a set a.TITLE=?1,  a.INTRODUCTION=?2 , a.LABEL=?3 , a.CONTENT=?4  where a.ID =?5 ")
	@Modifying
	public int updateByID(String TITLE,String INTRODUCTION,String LABEL,String CONTENT,int ID);
	

	

	
	
	
	

}

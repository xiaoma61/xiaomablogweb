package com.xiaoma.repository;
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
	
	@Query(value ="select a from ARTICLE a where a.TITLE like %?1% ")
	public List<ARTICLE>findByTITLELike(String TITLE);
	
	
	
	
	
	
	

}

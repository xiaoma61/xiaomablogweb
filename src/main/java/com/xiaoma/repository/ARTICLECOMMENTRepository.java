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
	
	
	@Query("select a from ARTICLECOMMENT a where a.ARTICLEID=?1 and a.PARENTID=?2")//����һ��
	public List<ARTICLECOMMENT>findByARTICLEID(int  ARTICLEID,int PARENTID);
	
	
	@Query("select a from ARTICLECOMMENT a where a.PARENTID=?1")//���Ҷ���
	public List<ARTICLECOMMENT>findByPARENTID(int  PARENTID);//����
	
	
	@Query("update  ARTICLECOMMENT a  set a.PRAISENUMS=?1 where a.ID=?2")//���Ҷ���
	@Modifying
	public int UpdatePRAISENUMSByID(int PRAISENUMS, int  ID);//����
	
	
	@Query("select a from ARTICLECOMMENT a where a.BELONGID=?1")//���Ҷ���
	public List<ARTICLECOMMENT>findByBELONGID(int  BELONGID);//����
	
	@Query("select a from ARTICLECOMMENT a where a.BELONGID=?1 and a.PARENTID=?2")//���Ҷ���
	public List<ARTICLECOMMENT>findByBELONGIDandPARENTID(int  BELONGID,int PARENTID);//����

}

package com.xiaoma.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.xiaoma.entity.FOLLOW;
@Transactional
public interface FOLLOWRepository extends JpaRepository<FOLLOW,Integer>{
	
	@Query(value =" select f from  FOLLOW f  where f.TOID=?1 and f.FROMID=?2")

	public FOLLOW findByTOID(int TOID ,int FROMID);
	
	
	@Query(value =" update  FOLLOW f set f.LIKETO=?1 , f.FOLLOW=?2  where  f.FROMID=?3 and  f.TOID=?4")
    @Modifying
	public int UpdateByTOID(int LIKETO ,int FOLLOW,int FROMID,int TOID);
	
	
	@Query(value =" select f from  FOLLOW f  where f.TOID=?1 and f.FOLLOW=?2")

	public List<FOLLOW> findByTOIDAndFOLLOW(int TOID ,int FOLLOW);
	
	@Query(value =" select f from  FOLLOW f  where f.FROMID=?1 and f.FOLLOW=?2")

	public List<FOLLOW> findByFROMID(int FROMID ,int FOLLOW );
	
	@Query(value =" select f from  FOLLOW f  where f.TOID=?1 and f.LIKETO=?2")

	public List<FOLLOW> findByTOIDAndISLIKE(int TOID ,int ISLIKE);
	
	
	@Query(value =" select f from  FOLLOW f  where f.FROMID=?1 and f.TOID=?2 and f.FOLLOW=?3")

	public FOLLOW findByFROMIDAndTOIDandFOLLOW(int FROMID ,int TOID,int FOLLOW);
	
	
	@Query(value =" select f from  FOLLOW f  where f.FROMID=?1 and f.TOID=?2 and f.LIKETO=?3")

	public FOLLOW findByFROMIDAndTOIDandLIKETO(int FROMID ,int TOID,int LIKETO);

}

package com.xiaoma.repository;

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
	public FOLLOW UpdateByTOID(int LIKETO ,int FOLLOW,int FROMID,int TOID);

}

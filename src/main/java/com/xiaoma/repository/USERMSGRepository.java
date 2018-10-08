package com.xiaoma.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import com.xiaoma.entity.USERMSG;
@Transactional
public interface USERMSGRepository extends JpaRepository<USERMSG,Integer>{
	//×¢²áÑéÖ¤
	@Query("select u   from  USERMSG u  where NAME=?1 and  PASSWORD=?2")
	public USERMSG findUSRByNameAndPASSWORD(String NAME,String PASSWORD );
	@Query("select u   from  USERMSG u  where NAME=?1 ")
	public USERMSG findUSRByName(String NAME );
	@Query("select u.ID   from  USERMSG u  where NAME=?1 ")
	public int  findIDByName(String NAME );
	@Modifying
	@Query("update USERMSG u  set u.IMAGE=?1 where u.ID=?2")
	public int updateImageByID(String Image,int ID);

}

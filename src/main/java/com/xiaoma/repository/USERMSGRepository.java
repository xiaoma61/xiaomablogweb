package com.xiaoma.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xiaoma.entity.USERMSG;
public interface USERMSGRepository extends JpaRepository<USERMSG,Integer>{
	//×¢²áÑéÖ¤
	@Query("select u   from  USERMSG u  where NAME=?1 and  PASSWORD=?2")
	public USERMSG findUSRByNameAndPASSWORD(String NAME,String PASSWORD );
	@Query("select u   from  USERMSG u  where NAME=?1 ")
	public USERMSG findUSRByName(String NAME );
	


}

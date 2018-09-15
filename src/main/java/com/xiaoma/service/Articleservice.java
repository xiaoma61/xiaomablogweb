package com.xiaoma.service;

import java.sql.Date;

import org.springframework.data.domain.Page;

import com.xiaoma.entity.ARTICLE;

public interface ArticleService {
	Page<ARTICLE> findARTICLECriteria(Integer page,Integer size,String ISSHOW);//带查询功能的
	Page<ARTICLE> findALLByTitle(Integer page,Integer size,String title,String ISSHOW);//带查询功能的
	Page<ARTICLE> findByCREATETIMEBetween(Integer page,Integer size,Date sDate,Date eDate,String ISSHOW);//带查询功能的
	Page<ARTICLE> findByCREATETIMELike(Integer page, Integer size, Date CREATETIME,String ISSHOW);
	
	Page<ARTICLE> findByLabel(Integer page, Integer size, String Label,String ISSHOW);
	
	//实现删除操作
	
	
}

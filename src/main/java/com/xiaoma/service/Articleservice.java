package com.xiaoma.service;

import org.springframework.data.domain.Page;

import com.xiaoma.entity.ARTICLE;

public interface ArticleService {
	Page<ARTICLE> findARTICLECriteria(Integer page,Integer size);//带查询功能的
	Page<ARTICLE> findALLByTitle(Integer page,Integer size,String title);//带查询功能的

}

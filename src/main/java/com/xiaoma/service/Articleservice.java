package com.xiaoma.service;

import java.sql.Date;

import org.springframework.data.domain.Page;

import com.xiaoma.entity.ARTICLE;

public interface ArticleService {
	Page<ARTICLE> findARTICLECriteria(Integer page,Integer size);//����ѯ���ܵ�
	Page<ARTICLE> findALLByTitle(Integer page,Integer size,String title);//����ѯ���ܵ�
	Page<ARTICLE> findByCREATETIMEBetween(Integer page,Integer size,Date sDate,Date eDate);//����ѯ���ܵ�

}

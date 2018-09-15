package com.xiaoma.service;

import java.sql.Date;

import org.springframework.data.domain.Page;

import com.xiaoma.entity.ARTICLE;

public interface ArticleService {
	Page<ARTICLE> findARTICLECriteria(Integer page,Integer size,String ISSHOW);//����ѯ���ܵ�
	Page<ARTICLE> findALLByTitle(Integer page,Integer size,String title,String ISSHOW);//����ѯ���ܵ�
	Page<ARTICLE> findByCREATETIMEBetween(Integer page,Integer size,Date sDate,Date eDate,String ISSHOW);//����ѯ���ܵ�
	Page<ARTICLE> findByCREATETIMELike(Integer page, Integer size, Date CREATETIME,String ISSHOW);
	
	Page<ARTICLE> findByLabel(Integer page, Integer size, String Label,String ISSHOW);
	
	//ʵ��ɾ������
	
	
}

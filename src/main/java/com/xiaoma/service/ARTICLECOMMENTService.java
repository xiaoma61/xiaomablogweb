package com.xiaoma.service;

import org.springframework.data.domain.Page;

import com.xiaoma.entity.ARTICLECOMMENT;

public interface ARTICLECOMMENTService {
	Page<ARTICLECOMMENT>findByPARENTID(int page ,int size ,int  PARENTID);
    Page<ARTICLECOMMENT>findByARTICLEID(int page,int size,int PARENTID,int ARTICLEID);
}

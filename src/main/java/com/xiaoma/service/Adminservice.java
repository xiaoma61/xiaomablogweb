package com.xiaoma.service;

import org.springframework.stereotype.Service;

import com.xiaoma.entity.ADMINISTRATOR;

@Service
public interface Adminservice{
	public ADMINISTRATOR FindByNameAndPassword(String Name, String Password);//—È÷§

}

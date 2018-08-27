package com.xiaoma.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.xiaoma.entity.ADMINISTRATOR;
import com.xiaoma.repository.ADMINISTRATORReposity;
import com.xiaoma.service.Adminservice;

public class ADMINISTRATORimpl implements Adminservice{

	@Autowired
	private ADMINISTRATORReposity AdminReposity;
	public ADMINISTRATOR FindByNameAndPassword(String Name, String Password) {
		// TODO Auto-generated method stub
		return AdminReposity.findBynameAndPassword(Name,Password);
	}

}

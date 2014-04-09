package org.j2eeframework.startoon.web.actions.enterprise.business;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.Business;
import org.j2eeframework.startoon.service.BusinessService;


public class BusinessListAction extends ServiceBasePaginationAction<Business, Long> {

	private static final long serialVersionUID = -2892651461245276201L;

	@Resource
	private BusinessService businessService;
	
	@Override
	public IGenericService<Business, Long> getGenericService()	{
		return businessService;
	}

	@Override
	public void preExecute() {
		
	}

}

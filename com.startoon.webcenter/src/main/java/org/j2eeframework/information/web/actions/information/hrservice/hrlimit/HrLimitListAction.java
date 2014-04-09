package org.j2eeframework.information.web.actions.information.hrservice.hrlimit;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.information.entity.HrLimit;
import org.j2eeframework.information.service.HrLimitService;


public class HrLimitListAction extends ServiceBasePaginationAction<HrLimit, Long> {

	private static final long serialVersionUID = 7874212532841818245L;

	@Resource
	private HrLimitService hrLimitService;
	
	@Override
	public IGenericService<HrLimit, Long> getGenericService()	{
		return hrLimitService;
	}

	@Override
	public void preExecute() {
		
	}

}

package org.j2eeframework.startoon.web.actions.enterprise.supplyparam;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.SupplyParam;
import org.j2eeframework.startoon.service.SupplyParamService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class SupplyParamListAction extends ServiceBasePaginationAction<SupplyParam, Long> {

	private static final long serialVersionUID = 1111758214839774721L;

	@Resource
	private SupplyParamService supplyParamService;
	
	@Override
	public IGenericService<SupplyParam, Long> getGenericService()	{
		return supplyParamService;
	}

	@Override
	public void preExecute() {
		
	}

}

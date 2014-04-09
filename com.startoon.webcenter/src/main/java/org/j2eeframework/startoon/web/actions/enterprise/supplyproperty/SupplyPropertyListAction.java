package org.j2eeframework.startoon.web.actions.enterprise.supplyproperty;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.SupplyProperty;
import org.j2eeframework.startoon.service.SupplyPropertyService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class SupplyPropertyListAction extends ServiceBasePaginationAction<SupplyProperty, Long> {

	private static final long serialVersionUID = -4181979532579508987L;

	@Resource
	private SupplyPropertyService supplyPropertyService;
	
	@Override
	public IGenericService<SupplyProperty, Long> getGenericService()	{
		return supplyPropertyService;
	}

	@Override
	public void preExecute() {
		
	}

}

package org.j2eeframework.startoon.web.actions.enterprise.crop;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Crop;
import org.j2eeframework.startoon.service.CropService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class CropListAction extends ServiceBasePaginationAction<Crop, Long> {

	private static final long serialVersionUID = -7778561191286721331L;

	@Resource
	private CropService cropService;
	
	@Override
	public IGenericService<Crop, Long> getGenericService()	{
		return cropService;
	}

	@Override
	public void preExecute() {
		
	}

}

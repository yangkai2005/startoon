package org.j2eeframework.startoon.web.actions.enterprise.entproduce;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.EntProduce;
import org.j2eeframework.startoon.service.EntProduceService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class EntProduceListAction extends ServiceBasePaginationAction<EntProduce, Long> {

	private static final long serialVersionUID = -73284456737581202L;

	@Resource
	private EntProduceService entProduceService;
	
	@Override
	public IGenericService<EntProduce, Long> getGenericService()	{
		return entProduceService;
	}

	@Override
	public void preExecute() {
		
	}

}

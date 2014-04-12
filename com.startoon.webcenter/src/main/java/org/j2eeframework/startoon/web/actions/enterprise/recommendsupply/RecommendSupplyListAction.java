package org.j2eeframework.startoon.web.actions.enterprise.recommendsupply;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.RecommendSupply;
import org.j2eeframework.startoon.service.RecommendSupplyService;

import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.commons.service.IGenericService;

public class RecommendSupplyListAction extends ServiceBasePaginationAction<RecommendSupply, Long> {

	private static final long serialVersionUID = 1694856307269911961L;

	@Resource
	private RecommendSupplyService recommendSupplyService;
	
	@Override
	public IGenericService<RecommendSupply, Long> getGenericService()	{
		return recommendSupplyService;
	}

	@Override
	public void preExecute() {
		
	}

}

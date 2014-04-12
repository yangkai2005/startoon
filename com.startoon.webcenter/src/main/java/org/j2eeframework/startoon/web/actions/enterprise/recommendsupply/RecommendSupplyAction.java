package org.j2eeframework.startoon.web.actions.enterprise.recommendsupply;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.RecommendSupply;
import org.j2eeframework.startoon.service.RecommendSupplyService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class RecommendSupplyAction extends ServiceBaseManageAction<RecommendSupply,Long>
{
	private static final long serialVersionUID = 2591695737866268117L;
	@Resource
	private RecommendSupplyService recommendSupplyService;
	private RecommendSupply recommendSupply;
	@Override
	public IGenericService<RecommendSupply, Long> getGenericService()
	{
		return recommendSupplyService;
	}

	public RecommendSupply getModel()
	{
		return recommendSupply;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			recommendSupply = new RecommendSupply();
		} else
		{
			recommendSupply = recommendSupplyService.getEntityById(getRequestId());
		}
	}

}

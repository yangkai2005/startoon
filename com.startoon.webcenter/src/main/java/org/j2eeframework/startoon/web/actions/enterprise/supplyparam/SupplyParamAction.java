package org.j2eeframework.startoon.web.actions.enterprise.supplyparam;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.SupplyParam;
import org.j2eeframework.startoon.service.SupplyParamService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class SupplyParamAction extends ServiceBaseManageAction<SupplyParam,Long>
{
	private static final long serialVersionUID = -7337329732614139594L;
	@Resource
	private SupplyParamService supplyParamService;
	private SupplyParam supplyParam;
	@Override
	public IGenericService<SupplyParam, Long> getGenericService()
	{
		return supplyParamService;
	}

	public SupplyParam getModel()
	{
		return supplyParam;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			supplyParam = new SupplyParam();
		} else
		{
			supplyParam = supplyParamService.getEntityById(getRequestId());
		}
	}

}

package org.j2eeframework.startoon.web.actions.enterprise.supplyproperty;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;
import org.j2eeframework.startoon.entity.SupplyProperty;
import org.j2eeframework.startoon.service.SupplyPropertyService;

public class SupplyPropertyAction extends ServiceBaseManageAction<SupplyProperty,Long>
{
	private static final long serialVersionUID = 2244211721519555669L;
	
	@Resource
	private SupplyPropertyService supplyPropertyService;
	
	private SupplyProperty supplyProperty;
	@Override
	public IGenericService<SupplyProperty, Long> getGenericService()
	{
		return supplyPropertyService;
	}

	public SupplyProperty getModel()
	{
		return supplyProperty;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			supplyProperty = new SupplyProperty();
		} else
		{
			supplyProperty = supplyPropertyService.getEntityById(getRequestId());
		}
	}
	

}

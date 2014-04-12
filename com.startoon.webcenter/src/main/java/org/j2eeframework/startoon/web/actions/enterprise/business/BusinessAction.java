package org.j2eeframework.startoon.web.actions.enterprise.business;

import javax.annotation.Resource;

import org.j2eeframework.startoon.entity.Business;
import org.j2eeframework.startoon.service.BusinessService;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBaseManageAction;

public class BusinessAction extends ServiceBaseManageAction<Business,Long>
{
	private static final long serialVersionUID = -825368888513915059L;
	@Resource
	private BusinessService businessService;
	private Business business;
	@Override
	public IGenericService<Business, Long> getGenericService()
	{
		return businessService;
	}

	public Business getModel()
	{
		return business;
	}

	public void prepare() throws Exception
	{
		if (getRequestId() == null || getRequestId() == 0)
		{
			business = new Business();
		} else
		{
			business = businessService.getEntityById(getRequestId());
		}
	}

}

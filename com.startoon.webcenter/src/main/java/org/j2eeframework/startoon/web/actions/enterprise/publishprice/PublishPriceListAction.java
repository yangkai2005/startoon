package org.j2eeframework.startoon.web.actions.enterprise.publishprice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;
import org.j2eeframework.startoon.entity.PublishPrice;
import org.j2eeframework.startoon.service.PublishPriceService;

public class PublishPriceListAction extends ServiceBasePaginationAction<PublishPrice, Long> {

	private static final long serialVersionUID = 2726085819810882640L;

	@Resource
	private PublishPriceService publishPriceService;
	
	@Override
	public IGenericService<PublishPrice, Long> getGenericService()	{
		return publishPriceService;
	}

	@Override
	public void preExecute() {
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		getPager().getParamCondition().addParameter("receiverId", user.getId() + "");
	}

}

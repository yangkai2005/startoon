package org.j2eeframework.startoon.web.actions.enterprise.askprice;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.AskPrice;
import org.j2eeframework.startoon.service.AskPriceService;


public class AskPriceListAction extends ServiceBasePaginationAction<AskPrice, Long> {

	private static final long serialVersionUID = 2247065415625592014L;

	@Resource
	private AskPriceService askPriceService;
	
	@Override
	public IGenericService<AskPrice, Long> getGenericService()	{
		return askPriceService;
	}

	@Override
	public void preExecute() {
		
		Long enterpriseId = SysContext.getCurrentEnterpriserUser().getId();
		getPager().getParamCondition().addParameter("enterpriseId", enterpriseId + "");
		
	}

}

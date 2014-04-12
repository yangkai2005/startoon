package org.j2eeframework.startoon.web.actions.enterprise.supply;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Supply;
import org.j2eeframework.startoon.service.SupplyService;

public class SupplyListAction extends ServiceBasePaginationAction<Supply, Long> {

	private static final long serialVersionUID = 3886122943517006966L;

	@Resource
	private SupplyService supplyService;
	
	@Override
	public IGenericService<Supply, Long> getGenericService()	{
		return supplyService;
	}

	@Override
	public void preExecute() {
		Long eid = SysContext.getCurrentEnterpriserUser().getId();
		getPager().getParamCondition().addParameter("enterpriseId", eid + "");
		if(getPager().getParamCondition().getParameter("status")==null) {
			getPager().getParamCondition().addParameter("status", "00");
		}
		
		int pageNo = getPager().getPageNo();
		if(pageNo==1) {
			getPager().getParamCondition().remove("flag");
		}
	}

}

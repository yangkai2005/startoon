package org.j2eeframework.information.web.actions.admin.information.cooperation;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;


public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = 3843675652376738402L;

	@Resource
	private InfoService infoService;
	
	@Override
	public IGenericService<Info, Long> getGenericService()	{
		return infoService;
	}

	@Override
	public void preExecute() {
		
		String[] ids = {"31", "32", "33", "34"};
		
		getPager().getParamCondition().addParameterValues("infoTypeIds", ids);
		
	}

}

package org.j2eeframework.startoon.web.actions.enterprise.cooperation;

import javax.annotation.Resource;

import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.commons.SysContext;


public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -5266725017947929566L;
	
	//private static final Log log = LogFactory.getLog(InfoListAction.class);

	@Resource
	private InfoService infoService;
	
	@Override
	public IGenericService<Info, Long> getGenericService()	{
		return infoService;
	}

	@Override
	public void preExecute() {
		ParamCondition paramCondition = getPager().getParamCondition();
		paramCondition.addParameter("creatorType", Info.CREATOR_TYPE_ENTERPRISE + "");
		paramCondition.addParameter("creator", SysContext.getCurrentEnterpriserUser().getId() + "");
		paramCondition.addParameter("status", "-1"); //在-1情况下不做任何限制，查询所有
	}

}

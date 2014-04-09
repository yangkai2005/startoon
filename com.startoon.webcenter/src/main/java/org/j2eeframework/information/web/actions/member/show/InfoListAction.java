package org.j2eeframework.information.web.actions.member.show;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.j2eeframework.commons.pager.ParamCondition;
import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;
import org.j2eeframework.information.entity.Info;
import org.j2eeframework.information.service.InfoService;
import org.j2eeframework.startoon.commons.SysContext;
import org.j2eeframework.startoon.entity.Enterprise;


public class InfoListAction extends ServiceBasePaginationAction<Info, Long> {

	private static final long serialVersionUID = -1670280820381760979L;

	private static final Log log = LogFactory.getLog(InfoListAction.class);
	

	@Resource
	private InfoService infoService;
	
	@Override
	public IGenericService<Info, Long> getGenericService()	{
		return infoService;
	}

	@Override
	public void preExecute() {
		
		Enterprise user = SysContext.getCurrentEnterpriserUser();
		
		log.debug("个人创意show列表查询[id:" + + user.getId() + "|account:" + user.getAccount() + "]");
		
		ParamCondition paramCondition = getPager().getParamCondition();
		paramCondition.addParameter("creator", "" + user.getId());
		paramCondition.addParameter("status", "-1");
	}

}

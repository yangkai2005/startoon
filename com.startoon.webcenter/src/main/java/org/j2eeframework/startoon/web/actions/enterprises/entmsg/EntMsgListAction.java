package org.j2eeframework.startoon.web.actions.enterprises.entmsg;

import javax.annotation.Resource;

import org.j2eeframework.commons.service.IGenericService;
import org.j2eeframework.commons.struts2.action.base.ServiceBasePaginationAction;

import org.j2eeframework.startoon.entity.EntMsg;
import org.j2eeframework.startoon.service.EntMsgService;


public class EntMsgListAction extends ServiceBasePaginationAction<EntMsg, Long> {

	private static final long serialVersionUID = 751512691456973768L;

	@Resource
	private EntMsgService entMsgService;
	
	@Override
	public IGenericService<EntMsg, Long> getGenericService()	{
		return entMsgService;
	}

	@Override
	public void preExecute() {
		
	}

}
